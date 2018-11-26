<!--我创建的团队-->
<template>
  <div class="create-container">
    <div class="item" v-for="item in list" :key="item.id">
      <img class="team-avatar" :src="item.avatar" width="90px" height="60px"/>
      <div class="right-wrapper">
        <div class="title">{{item.name}}</div>
        <div class="member-wrapper">
          <span class="text">成员: </span>
          <div class="member-item" v-for="member in item.members">
            <img class="avatar" :src="member.avatar" width="24px" height="24px" />
            <span class="mem-name">{{member.name}}</span>
          </div>
        </div>
        <div class="pjt-wrapper">
          <span class="text">项目:</span>
          <span class="pjt-name" v-for="(project, index) in item.projects">
            {{project.name + (index === item.projects.length-1 ? "" : "、")}}
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    components: {},
    props: {
      list: {
        type: Array
      }
    },
    data(){
      return{

      }
    },
    created(){

    },
    methods: {

    }
  }
</script>

<style scoped lang="scss">
  @import "../../../../public/scss/index";
  $title-size: 16px;
  $text-size: 14px;

  .create-container{
    display: flex;
    flex-direction: column;
    background-color: white;
    .item{
      display: flex;
      align-items: center;
      padding: 16px 10px;
      font-size: $text-size;
      color: $text-normal;
      border-bottom: 1px solid $border-fourth;
      &:last-child{
        border-bottom: none;
      }
      .avatar{
        border-radius: 50%;
        margin-right: 5px;
      }
      .right-wrapper{
        display: flex;
        flex-direction: column;
        margin-left: 10px;
        .title{
          font-size: $title-size;
          color: $text-main;
          cursor: pointer;
        }
        .text{
          margin-right: 5px;
        }
        .member-wrapper{
          display: flex;
          margin-top: 10px;
          align-items: center;
          .member-item{
            display: flex;
            align-items: center;
            margin-right: 16px;
          }
        }
        .pjt-wrapper{
          display: flex;
          align-items: center;
          margin-top: 10px;
        }
      }
    }

  }

</style>
