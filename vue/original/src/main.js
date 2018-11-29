import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "./registerServiceWorker";
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import api from './request/api'

Vue.config.productionTip = false;
Vue.use(ElementUI);
//挂载事件总线
Vue.prototype.bus = new Vue();
Vue.prototype.$api = api;

//注册全局导航守卫
router.beforeEach((to, from, next) => {
  //根据路由改变全局状态 isHome
  if(to.name === 'home'){
    store.commit("changeHomeState", true)
  }else{
    store.commit("changeHomeState", false)
  }
  next()
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
