<!--工作台-->
<template>
  <div class="container">
    <div class="left">
      <div class="item" :class="{active: currentTab === 0}" @click="clickItem(0)">我的项目</div>
      <div class="item" :class="{active: currentTab === 1}" @click="clickItem(1)">我的团队</div>
      <div class="item" :class="{active: currentTab === 2}" @click="clickItem(2)">组队申请</div>
    </div>
    <div class="right">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  export default {
    components: {},
    data(){
      return{
        currentTab: 0
      }
    },
    created(){
      this.setTabActive()
    },
    methods: {
      clickItem(index){
        this.currentTab = index;
        switch (index){
          case 0:
            this.$router.push({name: 'myproject'});
            break;
          case 1:
            this.$router.push({name: 'myteam'});
            break;
          case 2:
            this.$router.push({name: 'teamapply'});
            break;
        }
      },

      //根据当前路由地址设置选中的tab
      setTabActive(){
        let path = this.$route.path;
        let arr = path.split("/");
        let currentPath = arr[arr.length-1];
        if(currentPath === 'myproject'){
          this.currentTab = 0
        }else if(currentPath === 'myteam'){
          this.currentTab = 1
        }else {
          this.currentTab = 2
        }
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../../public/scss/index";
  .container{
    display: flex;
    flex-direction: row;
    width: 100%;
    height: 100%;
    margin-top: 10px;
    .left{
      display: flex;
      flex-direction: column;
      width: 180px;
      height: 150px;
      background-color: white;
      .item{
        font-size: 14px;
        line-height: 50px;
        text-align: center;
        cursor: pointer;
        &.active, &:hover{
          background-color: rgb(242,242,242);
        }
      }
    }
    .right{
      flex: 1;
      background-color: white;
      margin-left: 10px;
    }

  }
</style>
