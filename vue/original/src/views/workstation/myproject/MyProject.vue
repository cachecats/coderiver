<template>
  <div class="project-container">
    <div class="top-tab">
      <div class="tab-text" :class="{active: currentTab === 0}" @click="switchTab(0)">我创建的({{createdNum}})</div>
      <div class="divider"></div>
      <div class="tab-text" :class="{active: currentTab === 1}" @click="switchTab(1)">我加入的({{joinNum}})</div>
    </div>
    <div class="content">
      <project-component :list="listData" :type="currentTab ===0 ? 'created' : 'join'"></project-component>
    </div>
  </div>
</template>

<script>
  import MyProjectComponent from './MyProjectComponent'
  import ProjectMockData from '../../../mock/MyProject'

  export default {
    components: {
      "project-component": MyProjectComponent
    },
    data(){
      return {
        currentTab: 0,
        projectData: ProjectMockData
      }
    },
    computed: {
      listData(){
        if(this.currentTab === 0){
          return this.projectData.data.created
        }else{
          return this.projectData.data.join
        }
      },
      createdNum(){
        return this.projectData.data.created.length
      },
      joinNum(){
        return this.projectData.data.join.length
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
  .project-container{
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 100%;
    /*padding: 0 10px;*/
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
