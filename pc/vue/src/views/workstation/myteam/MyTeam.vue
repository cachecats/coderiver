<!--我的团队-->
<template>
  <div class="team-container">
    <div class="top-tab">
      <div class="tab-text" :class="{active: currentTab === 0}" @click="switchTab(0)">我创建的({{createdTeamNum}})</div>
      <div class="divider"></div>
      <div class="tab-text" :class="{active: currentTab === 1}" @click="switchTab(1)">我加入的({{joinTeamNum}})</div>
    </div>
    <div class="content">
      <team-component :list="listData"></team-component>
    </div>
  </div>
</template>

<script>

  import MockData from '../../../mock/MyTeam'
  import TeamComponent from './TeamComponent'

  export default {
    components: {
      "team-component": TeamComponent
    },
    data(){
      return{
        teamData: MockData,
        currentTab: 0
      }
    },
    created(){

    },
    computed: {
      listData(){
        if(this.currentTab === 0){
          return MockData.data[0].data
        }else{
          return MockData.data[1].data
        }
      },
      createdTeamNum(){
        return MockData.data[0].data.length
      },
      joinTeamNum(){
        return MockData.data[1].data.length
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
  .team-container{
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 100%;
    padding: 0 10px;
    box-sizing: border-box;
    .top-tab{
      display: flex;
      align-items: center;
      height: 50px;
      border-bottom: 1px solid $border-third;
      .tab-text{
        font-size: 14px;
        color: $text-normal;
        padding: 10px 20px;
        cursor: pointer;
        &.active{
          color: $color-main;
        }
      }
      .divider{
        width: 1px;
        height: 24px;
        background-color: $border-first;
      }
    }
    .content{
      flex: 1;
    }
  }
</style>
