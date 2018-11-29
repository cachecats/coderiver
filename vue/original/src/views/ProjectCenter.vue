<!--项目中心-->
<template>
  <div class="project-center">
    <condition-filter flag="project"></condition-filter>
    <div class="list">
      <div class="item" v-for="(item, index) in list">
        <div class="left">
          <img :src="item.avatar" width="120" height="80"/>
          <div class="bottom" :class="{active: item.teamStatus !== 0}">
            {{item.teamStatus === 0 ? "队员招募中" : "组队成功"}}
          </div>
        </div>
        <div class="right">
          <div class="row1">
            <span class="title" @click="goToDetail(item)">{{item.name}}</span>
            <span class="tag">{{item.typeName}}</span>
          </div>
          <div class="diff-wrapper">
            <span class="diff">难度：</span>
            <el-rate :value="item.difficulty" disabled show-score text-color="#606266"></el-rate>
          </div>
          <div class="text">
            简介：{{item.introduce}}
          </div>
          <div class="team-cast">
            <span>团队阵容: </span>
            <span class="team-item" v-for="team in item.teamCast">
              {{team.roleName + ": " + team.haveNum + "/" + team.needNum}}
            </span>
          </div>
          <div class="steps">
            <span class="step">进度：</span>
            <r-step :step="item.schedule"></r-step>
          </div>

        </div>
        <div class="btn">
          <el-button type="primary" @click="join(item)">{{item.teamStatus === 1 ? '查看' : '加入'}}</el-button>
        </div>
      </div>
    </div>
    <join-project :show="joinShow"></join-project>
  </div>
</template>

<script type="text/ecmascript-6">

  import ConditionFilter from '../components/ConditionFilter'
  import {ListData} from "../mock/ProjectList";
  import RStep from '../components/RStep'
  import JoinProject from '../components/JoinProject'

  export default {
    props: {

    },
    components: {
      "condition-filter": ConditionFilter,
      "r-step": RStep,
      "join-project": JoinProject,
    },
    data() {
      return {
        list: ListData.data,
        joinShow: { visible: false }
      }
    },
    created() {

    },
    methods: {

      //跳转到详情页面
      goToDetail(item){
        this.$router.push({name: 'project_detail', params: {id: item.id}})
      },

      join(item){
        //查看，进入详情
        if(item.teamStatus === 1){
          this.goToDetail(item)
        }else{
          this.joinShow.visible = true
        }
      }

    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  .project-center {
    @include main-wrapper;
    .list {
      width: 100%;
      .item {
        display: flex;
        position: relative;
        align-items: center;
        padding: 20px;
        box-sizing: border-box;
        background: white;
        margin-top: 10px;
        .left {
          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
          .bottom {
            margin-top: 10px;
            font-size: 14px;
            color: $text-normal;
            &.active{
              color: $color-success;
            }
          }
        }
        .right {
          display: flex;
          flex-direction: column;
          flex: 1;
          justify-content: start;
          align-items: start;
          margin-left: 20px;
          .row1 {
            color: $text-main;
            display: flex;
            align-items: center;
            .title {
              font-size: 18px;
              margin-right: 10px;
              cursor: pointer;
              &:hover {
                color: $color-main;
              }
            }
            .tag {
              font-size: 12px;
              padding: 4px 6px;
              background: $border-third;
              margin-right: 10px;
              font-weight: 500;
            }
          }
          .diff-wrapper{
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 10px;
            .diff{
              font-size: 14px;
              color: $text-normal;
            }
          }
          .text {
            font-size: 14px;
            color: $text-normal;
            padding-top: 10px;
          }
          .team-cast {
            font-size: 14px;
            color: $text-normal;
            padding-top: 10px;
            .team-item {
              margin-right: 10px;
            }
          }
          .steps{
            display: flex;
            align-items: center;
            width: 100%;
            margin-top: 10px;
            .step{
              font-size: 14px;
              color: $text-normal;
            }
          }
        }
        .like-wrapper {
          position: absolute;
          right: 20px;
          top: 20px;
          cursor: pointer;
          .num {
            margin-right: 5px;
            font-size: 14px;
            color: $text-normal;
            &.active {
              color: $color-main;
            }
          }
          .icon-like {
            font-size: 16px;
            color: $text-normal;
            &.active {
              color: $color-main;
            }
          }
        }
        .btn {
          padding-right: 60px;
        }
      }
    }
  }
</style>
