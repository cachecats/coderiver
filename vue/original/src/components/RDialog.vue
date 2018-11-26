<template>
  <el-dialog
      title="更新进度"
      :visible.sync="updateProgressShow"
      top="20vh"
      width="50%"
      :append-to-body="true">
    <slot></slot>
  </el-dialog>
</template>

<script>
  export default {
    components: {}
  }
</script>

<style scoped lang="scss">

</style>
