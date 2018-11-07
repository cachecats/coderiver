<template>
  <el-row>
    <el-col :span="6"><div class="div1"></div></el-col>
    <el-col :span="18"><div class="div2"></div></el-col>
  </el-row>
</template>

<script>
  export default {
    name: "HelloWorld",
    props: {
      msg: String
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
  .div1{
    height: 30px;
    background-color: aqua;
    padding: 10px;
  }

  .div2{
    height: 30px;
    background-color: indianred;
    padding: 10px;
  }
</style>
