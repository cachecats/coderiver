<!--步骤图-->
<template>
  <div class="r-step">
    <div class="step" :class="{active: step >= 1}">组队</div>
    <i class="iconfont icon-arrow-right" :class="{active: step >= 2}"></i>
    <div class="step" :class="{active: step >= 2}">设计</div>
    <i class="iconfont icon-arrow-right" :class="{active: step >= 3}"></i>
    <div class="step" :class="{active: step >= 3}">开发</div>
    <i class="iconfont icon-arrow-right" :class="{active: step >= 4}"></i>
    <div class="step" :class="{active: step >= 4}">完成</div>
  </div>
</template>

<script>
  export default {
    props: {
      step: {
        type: Number
      }
    },
    components: {},

  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  .r-step{
    display: flex;
    flex-direction: row;
    font-size: 14px;
    color: $text-normal;
    align-items: center;
    .iconfont{
      font-size: 12px;
      margin-left: 10px;
      margin-right: 10px;
      color: $text-normal;
    }
    .active{
      color: $color-success;
    }
  }
</style>
