/**
 * 操作cookie的工具类
 */
export default {

  /**
   * 设置Cookie
   * @param key
   * @param value
   */
  setCookie(key, value) {
    let exp = new Date();
    exp.setTime(exp.getTime() + 3 * 24 * 60 * 60 * 1000); //3天过期
    document.cookie = key + '=' + value + ';expires=' + exp + ";path=/";

  },

  /**
   * 移除Cookie
   * @param key
   */
  removeCookie(key) {
    setCookie(key, '', -1);//这里只需要把Cookie保质期退回一天便可以删除
  },

  /**
   * 获取Cookie
   * @param key
   * @returns {*}
   */
  getCookie(key) {
    let cookieArr = document.cookie.split('; ');
    for (let i = 0; i < cookieArr.length; i++) {
      let arr = cookieArr[i].split('=');
      if (arr[0] === key) {
        return arr[1];
      }
    }
    return false;
  }

}