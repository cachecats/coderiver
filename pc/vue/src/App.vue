<template>
  <div id="app">
    <div class="banner" v-if="isHome"></div>
    <div class="header-wrapper">
      <mheader/>
    </div>
    <div class="main-wrapper">
      <div class="side"></div>
      <div class="content">
        <router-view/>
      </div>
      <div class="side"></div>
    </div>
  </div>

</template>

<script>

  import home from '@/views/Home'
  import mheader from "@/components/mheader";

  export default {
    components: {
      mheader
    },
    computed: {
      isHome(){
        return this.$store.state.isHome
      }
    },
    created(){
      //改变全局状态 isHome
      this.$store.commit("changeHomeState", true)
    }
  }


</script>

<style scoped lang="scss">
  $app-bg-color: #f7f7f7;
  #app {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    width: 100%;
    background-color: $app-bg-color;
    box-sizing: border-box;
    position: relative;
    .banner{
      position: absolute;
      left: 0;
      top: 0;
      width: 100%;
      height: 550px;
      background-image: url("./assets/top-banner.jpg");
      z-index: 10;
    }
    .header-wrapper{
      position: fixed;
      width: 100%;
      top: 0;
      z-index: 200;
    }
    .main-wrapper {
      flex: 1;
      display: flex;
      flex-direction: row;
      width: 100%;
      padding-top: 80px;
      .side {
        flex: 1;
      }
      .content {
        width: 980px;
        z-index: 50;
      }
    }
  }


</style>
