<!--资源中心-->
<template>
  <div class="resource">
   <condition-filter flag="resource"></condition-filter>
  </div>

</template>

<script type="text/ecmascript-6">

  import ConditionFilter from '../components/ConditionFilter'

  export default {
    props: {},
    components: {
      "condition-filter": ConditionFilter
    },
    data() {
      return {}
    },
    created() {

    },
    methods: {}
  }
</script>

<style scoped lang="scss">
  @import "../../public/scss/index";

  .resource{
    @include main-wrapper
  }

</style>
