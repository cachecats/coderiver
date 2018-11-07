<template>
  <div class="project-detail">
    <div class="base-info">
      <div class="left">
        <img :src="info.avatar" width="120" height="80"/>
        <div class="bottom" :class="{active: info.teamStatus !== 0}">
          {{info.teamStatus === 0 ? "队员招募中" : "组队成功"}}
        </div>
      </div>
      <div class="right">
        <div class="row1">
          <span class="title">{{info.name}}</span>
        </div>
        <div class="diff-wrapper">
          <span class="diff">难度：</span>
          <el-rate :value="info.difficulty" disabled show-score text-color="#606266"></el-rate>
        </div>
        <div class="text">
          项目类型：{{info.typeName}}
        </div>
        <div class="team-cast">
          <span>团队阵容: </span>
          <span class="team-item" v-for="team in info.teamCast">
              {{team.roleName + ": " + team.haveNum + "/" + team.needNum}}
            </span>
        </div>
        <div class="steps">
          <span class="step">进度：</span>
          <r-step :step="info.schedule"></r-step>
        </div>

      </div>
      <div class="btn" v-if="info.teamStatus === 0">
        <el-button type="primary" @click="join(info)">加入项目</el-button>
      </div>
    </div>

    <div class="intro">
      <div class="title">项目简介</div>
      <div class="content">{{info.introduce}}</div>
    </div>

    <div class="member">
      <div class="title">团队成员</div>
      <div class="member-wrapper">
        <div class="content" v-for="team in info.teamCast">
          <div class="rolename">{{team.roleName}}:</div>
          <div class="member-info" v-for="member in team.member">
            <img class="avatar" :src="member.avatar" width="32px" height="32px"/>
            <span class="name">{{member.name}}</span>
          </div>
        </div>
      </div>
    </div>

    <div class="screenshot">
      <div class="title">项目截图</div>
      <div class="pic-wrapper">
        <img class="pic" v-for="pic in info.screenshot" :src="pic" width="220px" height="120px"/>
      </div>
    </div>

    <div class="comment">
      <div class="title">评论</div>
      <input-component :show="true"
                       type="end"
                       @cancel="cancelInput"
                       @confirm="commitComment">
      </input-component>
      <div class="comment-num">{{commentData.length}}条评论</div>
      <div class="content">
        <comment :comments="commentData"></comment>
      </div>
    </div>

    <join-project :show="joinShow"></join-project>
  </div>
</template>

<script>

  import {DetailData} from '../mock/ProjectDetail'
  import RStep from '../components/RStep'
  import * as CommentData from '../mock/CommentData'
  import comment from '../components/Comment'
  import JoinProject from '../components/JoinProject'
  import InputComponent from '../components/InputComponent'

  export default {
    components: {
      "r-step": RStep,
      "join-project": JoinProject,
      "input-component": InputComponent,
      comment
    },
    data() {
      return {
        info: {},
        commentData: [],
        joinShow: { visible: false }
      }
    },

    created() {
      this.info = DetailData.data;
      this.commentData = CommentData.comment.data;
    },

    methods: {
      join(info){
        this.joinShow.visible = true
      },

      //取消输入评论
      cancelInput(){

      },

      //提交评论
      commitComment(){

      }
    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  .project-detail {
    @include main-wrapper;
    .base-info {
      display: flex;
      flex-direction: row;
      align-items: center;
      padding: 20px;
      background-color: white;
      .left {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        .bottom {
          margin-top: 10px;
          font-size: 14px;
          color: $text-normal;
          &.active {
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
            font-weight: 700;
          }
          .tag {
            font-size: 12px;
            padding: 4px 6px;
            background: $border-third;
            margin-right: 10px;
            font-weight: 500;
          }
        }
        .diff-wrapper {
          display: flex;
          align-items: center;
          justify-content: center;
          margin-top: 10px;
          .diff {
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
        .steps {
          display: flex;
          align-items: center;
          width: 100%;
          margin-top: 10px;
          .step {
            font-size: 14px;
            color: $text-normal;
          }
        }
      }
      .btn {
        padding-right: 60px;
      }
    }
    .intro {
      display: flex;
      flex-direction: column;
      width: 100%;
      margin-top: 10px;
      background-color: white;
      .title {
        font-size: 16px;
        color: $text-main;
        font-weight: 700;
        padding: 10px;
        border-bottom: 1px solid $border-third;
      }
      .content {
        box-sizing: border-box;
        line-height: 20px;
        padding: 10px;
        font-size: 14px;
        color: $text-normal;
      }
    }
    .member {
      display: flex;
      flex-direction: column;
      width: 100%;
      margin-top: 10px;
      background-color: white;
      .title {
        font-size: 16px;
        color: $text-main;
        font-weight: 700;
        padding: 10px;
        border-bottom: 1px solid $border-third;
      }
      .member-wrapper {
        display: flex;
        flex-direction: column;
        padding-bottom: 20px;
        .content {
          display: flex;
          align-items: center;
          padding: 20px 20px 0;
          .rolename {
            width: 50px;
            font-size: 16px;
            color: $text-main;
            margin-right: 10px;
          }
          .member-info {
            width: 150px;
            display: flex;
            flex-direction: row;
            align-items: center;
            margin-left: 10px;
            .avatar {
              border-radius: 50%;
            }
            .name {
              flex: 1;
              font-size: 14px;
              color: $text-normal;
              margin-left: 10px;
              white-space: nowrap;
              text-overflow: ellipsis;
              overflow: hidden;
            }
          }
        }
      }

    }
    .screenshot{
      display: flex;
      flex-direction: column;
      width: 100%;
      margin-top: 10px;
      background-color: white;
      .title {
        font-size: 16px;
        color: $text-main;
        font-weight: 700;
        padding: 10px;
        border-bottom: 1px solid $border-third;
      }
      .pic-wrapper{
        padding: 10px;
        font-size: 0px;
        .pic{
          padding: 2px;
        }
      }
    }
    .comment {
      width: 100%;
      margin-top: 10px;
      padding-bottom: 10px;
      background-color: white;
      .title {
        font-size: 16px;
        color: $text-main;
        font-weight: 700;
        padding: 10px;
        border-bottom: 1px solid $border-third;
      }
      .comment-num {
        font-size: 16px;
        color: $text-main;
        font-weight: 600;
        margin: 0 20px;
        padding: 10px 0;
      }
    }
  }
</style>
