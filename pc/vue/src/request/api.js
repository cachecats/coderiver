
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
    return axios.post(`${base}/user/register`, qs.stringify(params))
  },

  /**
   * 获取所有的角色
   * @returns {*}
   */
  getAllRoles(){
    return axios.get(`${base}/user/get-roles`)
  },

  /**
   * 获取所有的经验
   * @returns {*}
   */
  getAllExperiences(){
    return axios.get(`${base}/user/get-experiences`)
  }




}