<!--邀请组队-->
<template>
  <div>
    <el-dialog
        title="加入项目"
        :visible.sync="show.visible"
        top="20vh"
        width="50%"
        :append-to-body="true">
      <div class="content">
        <div class="row1">
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
          <span class="who">选择你的角色</span>
        </div>

        <div class="row2">
          <span class="title">可支配时间</span>
          <div class="time">
            <div class="workday">
              <span class="text">工作日</span>
              <el-time-select
                  placeholder="起始时间"
                  v-model="workdayStartTime"
                  :picker-options="{
                    start: '00:00',
                    step: '00:15',
                    end: '24:00'
                  }">
              </el-time-select>
              <span class="gap"></span>
              <el-time-select
                  placeholder="结束时间"
                  v-model="workdayEndTime"
                  :picker-options="{
                    start: '00:00',
                    step: '00:15',
                    end: '24:00'
                  }">
              </el-time-select>
            </div>
            <div class="weekend">
              <span class="text">周六日</span>
              <el-time-select
                  placeholder="起始时间"
                  v-model="weekendStartTime"
                  :picker-options="{
                    start: '00:00',
                    step: '00:15',
                    end: '24:00'
                  }">
              </el-time-select>
              <span class="gap"></span>
              <el-time-select
                  placeholder="结束时间"
                  v-model="weekendEndTime"
                  :picker-options="{
                    start: '00:00',
                    step: '00:15',
                    end: '24:00'
                  }">
              </el-time-select>
            </div>
          </div>
        </div>

        <div class="row3">
          <div class="title">备注</div>
          <div class="input-wrapper">
            <el-input
                v-model="inputComment"
                type="textarea"
                :rows="3"
                placeholder="备注信息"
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
        //选择的角色
        selectRole: '',
        roleInfo: ROLE,
        //备注内容
        inputComment: '',
        workdayStartTime: '',
        workdayEndTime: '',
        weekendStartTime: '',
        weekendEndTime: '',
      }
    },
    computed: {
      dialogVisible() {
        return this.visible
      }
    },
    methods: {
      //选择角色回调
      roleChange(value) {
        console.log(value)
        this.selectRole = value
      },

      cancel() {
        this.show.visible = false
      },

      confirm() {
        console.log("role", this.selectRole);
        console.log("comment", this.inputComment);
        this.show.visible = false
      }
    },
    mounted() {

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
      .who {
        color: $text-minor;
        margin-left: 20px;
      }
    }
    .row2 {
      display: flex;
      align-items: center;
      font-size: 14px;
      margin-top: 20px;
      .title {
        display: inline-block;
        width: 80px;
        color: $text-main;
      }
      .time {
        display: flex;
        flex-direction: column;
        flex: 1;
        .workday {
          display: flex;
          align-items: center;
          color: $text-normal;
          .text {
            margin-right: 15px;
          }
          .gap {
            display: inline-block;
            width: 10px;
          }
        }
        .weekend {
          display: flex;
          align-items: center;
          margin-top: 10px;
          color: $text-normal;
          .text {
            margin-right: 15px;
          }
          .gap {
            display: inline-block;
            width: 10px;
          }
        }
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
