<!--组队申请-->
<template>
  <div class="team-apply">
    <div class="top-tab">
      <div class="tab-text" :class="{active: currentTab === 0}" @click="switchTab(0)">我审批的({{auditNum}})</div>
      <div class="divider"></div>
      <div class="tab-text" :class="{active: currentTab === 1}" @click="switchTab(1)">我申请的({{applyNum}})</div>
    </div>
    <div class="content">
      <team-apply-component :list="listData" :type="currentTab === 0 ? 'audit' : 'apply'"></team-apply-component>
    </div>
  </div>
</template>

<script>
  import TeamApplyData from '../../../mock/TeamApply'
  import TeamApplyComponent from './TeamApplyComponent'

  export default {
    components: {
      "team-apply-component": TeamApplyComponent
    },
    data() {
      return {
        currentTab: 0,

      }
    },
    computed: {
      listData(){
        if(this.currentTab === 0){
          return TeamApplyData.data[0].data
        }else{
          return TeamApplyData.data[1].data
        }
      },
      auditNum(){
        return TeamApplyData.data[0].data.length
      },
      applyNum(){
        return TeamApplyData.data[1].data.length
      }
    },
    methods: {
      switchTab(index){
        this.currentTab = index
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../../../public/scss/index";

  .team-apply {
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 100%;
    padding: 0 10px;
    box-sizing: border-box;
    .top-tab {
      display: flex;
      align-items: center;
      height: 50px;
      border-bottom: 1px solid $border-third;
      .tab-text {
        font-size: 14px;
        color: $text-normal;
        padding: 10px 20px;
        cursor: pointer;
        &.active {
          color: $color-main;
        }
      }
      .divider {
        width: 1px;
        height: 24px;
        background-color: $border-first;
      }
    }
    .content {
      flex: 1;
    }
  }
</style>
