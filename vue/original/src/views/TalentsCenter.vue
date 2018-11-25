<!--人才广场-->
<template>
  <div class="talents">
    <condition-filter flag="talents"></condition-filter>
    <div class="list">
      <div class="item" v-for="(item, index) in list">
        <div class="left">
          <img src="../assets/avatar.png" width="64" height="64"/>
          <div class="bottom">
            <span class="influence">影响力: {{item.influence}}</span>
            <i class="iconfont" :class="item.sex === 0 ? 'icon-sexw' : 'icon-sexm'"></i>
          </div>
        </div>
        <div class="right">
          <div class="row1">
            <span class="wrapper" @click="goToDetail(item)">
              <span class="title">{{item.name}}</span>
              <span class="title">{{item.roleName}}</span>
            </span>
            <span class="tag">{{item.city}}</span>
            <span class="tag">{{item.experienceName}}</span>
          </div>
          <div class="text">技能：{{item.skill}}</div>
          <div class="text" v-if="item.teamName">团队：{{item.teamName}}</div>
          <div class="text">
            战绩：{{"已完成:" + item.recordSuccess + ", 进行中:" + item.recordDeveloping + ", 失败:"+item.recordFail}}
          </div>
          <div class="time">
            <span>可支配时间: </span>
            <span class="workday">工作日: {{item.workdayIdleStartTime + " - " + item.workdayIdleEndTime}}</span>
            <span>周末: {{item.weekendIdleStartTime + " - " + item.weekendIdleEndTime}}</span>
          </div>
        </div>
        <div class="like-wrapper" @click="clickLike(item)">
          <span class="num" :class="{active: item.isLike}">{{item.likeNum}}</span>
          <i class="iconfont icon-like" :class="{active: item.isLike}"></i>
        </div>
        <div class="btn">
          <el-button type="primary" @click="inviteTeam(item)">邀请组队</el-button>
        </div>
      </div>
    </div>
    <invite-team :show="inviteShow"></invite-team>
  </div>
</template>

<script type="text/ecmascript-6">

  import ConditionFilter from '../components/ConditionFilter'
  import TalentList from '../mock/TalentsList'
  import Vue from 'vue'
  import InviteTeam from '../components/InviteTeam'

  export default {
    props: {},
    components: {
      "condition-filter": ConditionFilter,
      "invite-team": InviteTeam
    },
    data() {
      return {
        list: TalentList.data,
        inviteShow: { visible: false },
      }
    },
    created() {

    },
    methods: {

      /**
       * 点赞
       * @param item
       */
      clickLike(item) {
        console.log(item);
        if (item.isLike) {
          item.isLike = !item.isLike;
          item.likeNum--
        } else {
          Vue.set(item, "isLike", true);
          item.likeNum++
        }
      },

      /**
       * 跳转到详情页面
       * @param item
       */
      goToDetail(item) {
        this.$router.push({name: "talents_detail", params: {item: item}})
      },

      /**
       * 邀请组队
       * @param item
       */
      inviteTeam(item) {
        console.log(item);
        this.inviteShow.visible = true
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../public/scss/index";

  .talents {
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
            .influence {
              font-size: 14px;
              color: $text-normal;
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
            .wrapper {
              cursor: pointer;
              .title {
                font-size: 18px;
                margin-right: 10px;
              }
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
          .text {
            font-size: 14px;
            color: $text-normal;
            padding-top: 10px;
          }
          .time {
            font-size: 14px;
            color: $text-normal;
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
    }
  }

</style>
