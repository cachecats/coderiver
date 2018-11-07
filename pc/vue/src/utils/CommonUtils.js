
export default {

  /**
   * 验证邮箱
   * @param email 邮箱地址
   * @returns {boolean} 验证成功返回true，失败返回false
   */
  checkEmail(email){
    let re = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/
    if(re.test(email)){
      return true
    }
    return false
  },

  deleteArrayItem(arr, item){
    arr.forEach( (val, index) => {
      if(val.id === item.id){
        arr.splice(index,1)
      }
    });
    return arr
  }
}