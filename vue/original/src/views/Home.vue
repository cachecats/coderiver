<template>
  <div class="home">
    <h1>Home</h1>
  </div>
</template>

<script>
// @ is an alias to /src
// import mheader from "@/components/mHeader";

export default {
  name: "home",
  components: {
    // mheader
  },
  created(){
    console.log("isHome",this.$store.state.isHome)
  }
};
</script>

<style scoped lang="scss">
  @import "../../public/scss/index";

  .home{
    @include main-wrapper
  }
</style>