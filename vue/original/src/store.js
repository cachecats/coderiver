import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isHome: true,
    network: true,
    userInfo: {}
  },
  mutations: {
    changeHomeState(state, flag){
      state.isHome = flag
    },
    changeNetwork(state, flag){
      state.network = flag
    },
    setUserInfo(state, userInfo){
      state.userInfo = userInfo
    }
  },
  actions: {}
});
