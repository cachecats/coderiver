import axios from 'axios'
import router from '../router'
import store from '../store'
import {Message} from 'element-ui'

/**
 * Toast提示函数
 * @param msg
 */
const tip = msg => {
  Message.error(msg)
};

/**
 * 跳转到登录页面
 */
const toLogin = () => {
  //跳转到登录页面
  tip("未授权，登录")
};

/**
 * 统一错误处理
 * @param status
 * @param other
 */
const errorHandle = (status, other) => {
  switch (status) {
    //401未登录
    case 401:
      toLogin();
      break;
    //登录过期，重新登录
    case 403:
      tip("登录过期，请重新登录");
      setTimeout(() => {
        toLogin()
      }, 1000);
      break;
    case 404:
      tip("请求资源不存在");
      break;
    default:
      console.log(other)
  }
};

//创建 axios 实例
let instance = axios.create({timeout: 1000 * 12});
//设置post请求头
instance.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// instance.defaults.headers.post['Content-Type'] = 'application/json';
instance.defaults.withCredentials = true; //让ajax携带cookie

/**
 * 请求拦截器
 * 每次请求前，如果存在token就在请求头中携带token
 */
instance.interceptors.request.use(
  config => {
    // 登录流程控制中，根据本地是否存在token判断用户的登录情况
    // 但是即使token存在，也有可能token是过期的，所以在每次的请求头中携带token
    // 后台根据携带的token判断用户的登录情况，并返回给我们对应的状态码
    // 而后我们可以在响应拦截器中，根据状态码进行一些统一的操作。
    const token = store.state.token;
    // tip("token:" + token);
    token && (config.headers.Authorization = token);
    return config;
  },
  error => Promise.error(error)
);

instance.interceptors.response.use(
  res => {
    console.log("response:", res)
    if (res.data.code === 200) {
      return Promise.resolve(res.data)
    } else {
      return Promise.reject(res)
    }
  },
  error => {
    console.log("response-error:", error);
    const {response} = error;
    if (response) {
      //请求已发出，但是不在 2xx 范围内
      errorHandle(response.status, response.data.message);
      return Promise.reject(response)
    } else {
      // 处理断网的情况
      // eg:请求超时或断网时，更新state的network状态
      // network状态在app.vue中控制着一个全局的断网提示组件的显示隐藏
      // 关于断网组件中的刷新重新获取数据，会在断网组件中说明
      store.commit('changeNetwork', false);
    }
  }
)
;

export default instance