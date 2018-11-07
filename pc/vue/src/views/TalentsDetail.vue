<!--人才详情页-->
<template>
  <div class="container">
    <div class="basic-info">
      <div class="left">
        <img src="../assets/avatar.png" width="80" height="80"/>
        <div class="bottom">
          <span class="influence">影响力: {{info.influence}}</span>
          <i class="iconfont" :class="info.sex === 0 ? 'icon-sexw' : 'icon-sexm'"></i>
        </div>
      </div>
      <div class="right">
        <div class="row1">
          <span class="title">{{info.name}}</span>
          <span class="title">{{info.roleName}}</span>
        </div>
        <div class="text">城市：{{info.city}}</div>
        <div class="text">经验：{{info.experienceName}}</div>
        <div class="text">技能：{{info.skill}}</div>
        <div class="text" v-if="info.teamName">团队：{{info.teamName}}</div>
        <div class="text">
          战绩：{{"已完成:" + info.recordSuccess + ", 进行中:" + info.recordDeveloping + ", 失败:"+info.recordFail}}
        </div>
        <div class="time">
          <span>可支配时间: </span>
          <span class="workday">工作日: {{info.workdayIdleStartTime + " - " + info.workdayIdleEndTime}}</span>
          <span>周末: {{info.weekendIdleStartTime + " - " + info.weekendIdleEndTime}}</span>
        </div>
      </div>
      <div class="like-wrapper" @click="clickLike()">
        <span class="num" :class="{active: info.isLike}">{{info.likeNum}}</span>
        <i class="iconfont icon-like" :class="{active: info.isLike}"></i>
      </div>
      <div class="btn">
        <el-button type="primary" @click="showInviteTeamDialog">邀请组队</el-button>
      </div>
    </div>
    <div class="project">
      <div class="title">项目成就</div>
      <div class="record" v-for="record in projectRecord">
        <div class="left">{{record.text}}</div>
        <div class="right">
          <div class="item-wrapper" v-for="item in record.data" @click="goProjectDetail(item.id)">
            <img class="img" :src="item.img" width="60" height="40"/>
            <span class="name">{{item.name}}</span>
            <span class="role">角色: {{item.roleName}}</span>
          </div>
        </div>
      </div>
    </div>
    <div class="introduce">
      <div class="title">个人介绍</div>
      <div class="content">{{info.introduce}}</div>
    </div>
    <div class="edu">
      <div class="title">教育经历</div>
      <div class="content" v-for="item in info.eduExperience">
        <span class="label">{{item.startDate}} - {{item.endDate}}</span>
        <span class="label">{{item.school}}</span>
        <span class="label">{{item.major}}</span>
        <span class="label">{{item.degree}}</span>
        <div class="desc">{{item.desc}}</div>
      </div>
    </div>
    <div class="work">
      <div class="title">工作经历</div>
      <div class="content" v-for="item in info.workExperience">
        <span class="label">{{item.startDate}} - {{item.endDate}}</span>
        <span class="label">{{item.company}}</span>
        <span class="label">{{item.position}}</span>
        <div class="desc">{{item.desc}}</div>
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

    <invite-team :show="inviteTeam"></invite-team>
  </div>
</template>

<script>

  import * as MockData from '../mock/TalentsDetail'
  import * as CommentData from '../mock/CommentData'
  import Vue from 'vue'
  import comment from '../components/Comment'
  import InputComponent from '../components/InputComponent'
  import InviteTeam from '../components/InviteTeam'

  export default {
    components: {
      comment,
      "input-component": InputComponent,
      "invite-team": InviteTeam
    },
    data() {
      return {
        info: {},
        projectRecord: [],
        commentData: [],
        inviteTeam: {visible: false},
      }
    },
    created() {
      // this.introduce = this.$route.params.item;
      // console.log(this.introduce);

      this.projectRecord = MockData.projectRecord;
      this.info = MockData.info;
      this.commentData = CommentData.comment.data;
    },
    methods: {
      /**
       * 点赞
       */
      clickLike() {
        if (this.info.isLike) {
          this.info.isLike = !this.info.isLike;
          this.info.likeNum--
        } else {
          Vue.set(this.info, "isLike", true);
          this.info.likeNum++
        }
      },
      /**
       * 跳转到项目详情
       */
      goProjectDetail(id) {
        this.$message("跳到项目详情" + id)
      },

      cancelInput() {

      },

      commitComment() {

      },

      showInviteTeamDialog(){
        this.inviteTeam.visible = true
      }
    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  .container {
    @include main-wrapper;
    margin-bottom: 20px;
    .basic-info {
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
        padding: 0 20px;
        .bottom {
          margin-top: 20px;
          .influence {
            font-size: 14px;
            color: $text-main;
            margin-right: 10px;
          }
          .icon-sexw {
            font-size: 16px;
            color: rgb(248, 145, 155);
          }
          .icon-sexm {
            font-size: 16px;
            color: rgb(131, 210, 251);
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
        }
        .text {
          font-size: 14px;
          color: $text-main;
          padding-top: 10px;
        }
        .time {
          font-size: 14px;
          color: $text-main;
          padding-top: 10px;
          .workday {
            margin-right: 10px;
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
    .project {
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
      .record {
        display: flex;
        flex-direction: row;
        align-items: center;
        width: 100%;
        .left {
          width: 80px;
          font-size: 16px;
          font-weight: 500;
          color: $text-main;
          text-align: center;
        }
        .right {
          flex: 1;
          display: flex;
          align-items: center;
          flex-wrap: wrap;
          .item-wrapper {
            padding: 10px;
            position: relative;
            width: 180px;
            margin-right: 10px;
            cursor: pointer;
            .name {
              width: 120px;
              position: absolute;
              top: 10px;
              padding-left: 10px;
              font-size: 16px;
              color: $text-main;
              overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
              &:hover {
                color: $color-main;
              }
            }
            .role {
              position: relative;
              bottom: 3px;
              padding-left: 10px;
              font-size: 14px;
              color: $text-normal;
            }
          }

        }
      }
    }
    .introduce {
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
    .edu {
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
      .content {
        box-sizing: border-box;
        line-height: 20px;
        padding: 6px 10px 0;
        .label {
          font-size: 14px;
          color: $color-main;
          padding-right: 16px;
        }
        .desc {
          box-sizing: border-box;
          line-height: 20px;
          font-size: 14px;
          color: $text-normal;
          padding-top: 4px;
        }
      }
    }
    .work {
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
      .content {
        box-sizing: border-box;
        line-height: 20px;
        padding: 6px 10px 0;
        .label {
          font-size: 14px;
          color: $color-main;
          padding-right: 16px;
        }
        .desc {
          box-sizing: border-box;
          line-height: 20px;
          font-size: 14px;
          color: $text-normal;
          padding-top: 4px;
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
      .content {
        /*padding: 10px;*/
      }
    }
  }

</style>
