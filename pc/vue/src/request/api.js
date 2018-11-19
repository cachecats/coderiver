
import axios from './http'
import qs from 'query-string'

const base = "http://localhost:8084";

/**
 * api请求方法
 * post请求要先序列化
 */
export default {

  login(params){
    return axios.post(`${base}/user/login`, qs.stringify(params))
  },

  register(params){
    let p = qs.stringify(params);
    console.log("stringify: ", p);
    return axios.post(`${base}/user/registry`, {params: p})
  },




}