<!--邀请组队-->
<template>
  <div>
    <el-dialog
        title="邀请组队"
        :visible.sync="show.visible"
        top="20vh"
        width="50%"
        :append-to-body="true">
      <div class="content">
        <div class="row1">
          <span class="title">选择项目</span>
          <el-select v-model="selectProject" placeholder="请选择" @change="projectChange">
            <el-option
                v-for="item in projectInfo"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                size="small">
            </el-option>
          </el-select>
          <span class="no-project">没有项目？新建</span>
        </div>
        <div class="row2">
          <span class="title">选择角色</span>
          <el-select v-model="selectRole" placeholder="请选择" @change="roleChange">
            <el-option
                v-for="item in roleInfo"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                size="small">
            </el-option>
          </el-select>
          <span class="who">希望 TA 作为团队中的什么角色呢</span>
        </div>
        <div class="row3">
          <div class="title">备注</div>
          <div class="input-wrapper">
            <el-input
                v-model="inputComment"
                type="textarea"
                :rows="3"
                placeholder="写下你的评论"
            ></el-input>
          </div>
        </div>
        <div class="btn-wrapper">
          <el-button @click="cancel">取消</el-button>
          <el-button type="primary" @click="confirm">确定</el-button>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  //当前登录用户的项目信息
  const MyProject = [
    {id: "0001", name: "闲书"},
    {id: "0002", name: "共享图书"}
  ];

  const ROLE = [
    {id: 'designer', name: '设计师'},
    {id: 'frontEnd', name: '前端工程师'},
    {id: 'backEnd', name: '后端工程师'},
    {id: 'mobile', name: '移动端工程师'},
    {id: 'game', name: '游戏工程师'},
    {id: 'pm', name: '产品经理'},
  ];


  export default {
    name: 'InviteTeam',
    props: {
      //使用对象就可以直接更改props不报错了
      show: {
        type: Object,
      }
    },
    components: {},
    data() {
      return {
        //选择的项目
        selectProject: '',
        projectInfo: MyProject,
        //选择的角色
        selectRole: '',
        roleInfo: ROLE,
        //备注内容
        inputComment: ''
      }
    },
    computed: {
      dialogVisible() {
        return this.visible
      }
    },
    methods: {
      //选择项目回调
      projectChange(value) {
        console.log(value)
        this.selectProject = value
      },

      //选择角色回调
      roleChange(value) {
        console.log(value)
        this.selectRole = value
      },

      cancel(){
        this.show.visible = false
      },

      confirm(){
        console.log("project", this.selectProject);
        console.log("role", this.selectRole);
        console.log("comment", this.inputComment);
        this.show.visible = false
      }
    },
    mounted() {
      console.log(this.selectProject)
    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  .content {
    display: flex;
    flex-direction: column;
    .row1 {
      font-size: 14px;
      .title {
        display: inline-block;
        width: 80px;
        color: $text-main;
      }
      .no-project {
        color: $color-main;
        margin-left: 20px;
      }
    }
    .row2 {
      margin-top: 20px;
      font-size: 14px;
      .title {
        display: inline-block;
        width: 80px;
        color: $text-main;
      }
      .who {
        color: $text-minor;
        margin-left: 20px;
      }
    }
    .row3 {
      display: flex;
      margin-top: 20px;
      font-size: 14px;
      .title {
        width: 80px;
        color: $text-main;
      }
      .input-wrapper {
        flex: 1;
      }
    }
    .btn-wrapper {
      display: flex;
      align-items: center;
      justify-content: flex-end;
      margin-top: 20px;

    }
  }
</style>
