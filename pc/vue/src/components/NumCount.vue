<!--仿外卖加减数量小组件-->
<template>
  <div class="num-count">
    <div class="sub" @click="subtract">
      <i class="el-icon-remove-outline" :class="{active: info.num > 0}"></i>
    </div>
    <span class="count">{{info.num}}</span>
    <div class="add" @click="add">
      <i class="el-icon-circle-plus-outline"></i>
    </div>
  </div>
</template>

<script>
  export default {
    components: {},
    props: {
      info: {
        type: Object
      }
    },
    data(){
      return{

      }
    },
    methods: {
      subtract(){
        console.log('subtract');
        if(this.info.num > 0){
          this.info.num--
        }
      },

      add(){
        console.log('add');
        this.info.num++
      },


    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";
  .num-count{
    display: flex;
    flex-direction: row;
    align-items: center;
    .sub{
      padding: 10px;
      .el-icon-remove-outline{
        font-size: 20px;
        color: $text-normal;
        &.active{
          color: $color-main;
        }
      }
    }
    .add{
      padding: 10px;
      .el-icon-circle-plus-outline{
        font-size: 20px;
        color: $color-main;
      }
    }

    .count{
      font-size: 16px;
      color: $text-normal;
      padding: 0 16px;
    }
  }
</style>
