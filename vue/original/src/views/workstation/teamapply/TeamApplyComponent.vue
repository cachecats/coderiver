<!--组队申请小组件-->
<template>
  <div class="apply-container">
    <div class="item" v-for="item in list" :key="item.id">
      <div class="audit-avatar" v-if="type === 'audit'" :style="{backgroundImage: 'url(' + item.avatar + ')'}"></div>
      <img class="apply-avatar" v-if="type === 'apply'" :src="item.avatar" width="90px" height="60px"/>
      <div class="right-wrapper">
        <div class="title-wrapper">
          <span class="title">{{titleName(item)}}</span>
          <span class="tag" v-if="type === 'audit'">{{item.applyUserInfo.city}}</span>
          <span class="tag" v-if="type === 'audit'">{{item.applyUserInfo.experienceName}}</span>
        </div>
        <div class="row1-wrapper">
          <div class="role-wrapper" v-if="type === 'audit'">
            <span>申请项目: </span>
            <span class="role">{{item.applyProjectName}}</span>
          </div>
          <div class="role-wrapper">
            <span>职位: </span>
            <span class="role">{{item.applyRoleName}}</span>
          </div>
        </div>
        <div class="time">
          <span>可支配时间: </span>
          <span class="workday">工作日: {{item.workdayIdleStartTime + " - " + item.workdayIdleEndTime}}</span>
          <span>周末: {{item.weekendIdleStartTime + " - " + item.weekendIdleEndTime}}</span>
        </div>
        <div class="remark-wrapper">
          <span>备注：</span>
          <span>{{item.remark}}</span>
        </div>
      </div>

      <div class="btn-wrapper" v-if="item.status === 1">
        <el-button type="primary" size="small" @click="auditPass(item)">通过</el-button>
        <el-button type="danger" size="small" @click="auditReject(item)">婉拒</el-button>
      </div>

      <div class="btn-wrapper" v-if="item.status !== 1">
        <img src="../../../../public/img/pass.png" v-if="item.status === 2" width="60px" height="60px"/>
        <img src="../../../../public/img/not_pass.png" v-if="item.status === 3" width="60px" height="60px"/>
        <el-button class="delete-btn" type="danger" size="small" @click="deleteItem(item.id)">删除</el-button>
      </div>
    </div>

    <el-dialog
        title="拒绝原因"
        :visible.sync="rejectDialogShow"
        top="20vh"
        width="50%"
        :append-to-body="true">
      <div class="dialog-content">
        <el-input
            v-model="inputReason"
            type="textarea"
            :rows="3"
            placeholder="告诉Ta为什么被拒绝吧"
        ></el-input>
        <div class="btn-wrapper">
          <el-button @click="rejectDialogShow = false">取消</el-button>
          <el-button type="primary" @click="submitRejectReason">确定</el-button>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  const TYPE_AUDIT = "audit";
  const TYPE_APPLY = "apply";

  //审核状态
  const STATUS_WAIT = 1;
  const STATUS_PASS = 2;
  const STATUS_NOT_PASS = 3;


  export default {
    props: {
      list: {
        type: Array
      },
      type: { // 我申请的apply, 待审核audit
        type: String
      }
    },
    components: {},
    data() {
      return {
        rejectDialogShow: false,  //拒绝Dialog是否显示
        passConfirmShow: false,  //通过确认Dialog是否显示
        inputReason: '',  //拒绝原因
        currentItem: {},
        test: ''
      }
    },
    computed: {

    },
    methods: {
      titleName(item) {
        console.log("item", item)
        // 我申请的标题展示项目名字，我审核的展示申请者名字
        if (this.type === TYPE_APPLY) {
          return item.applyProjectName
        } else {
          return item.applyUserInfo.name
        }
      },

      //通过组队申请
      auditPass(item) {
        this.currentItem = item;
        this.$confirm(`确定接受 ${item.applyUserInfo.name} 作为项目 ${item.applyProjectName} 的 ${item.applyRoleName} 吗？`, "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'success',
          callback: (action) => {
            if(action === 'confirm'){
              this.$message({
                type: 'success',
                message: '确认成功，请及时与对方取得联系'
              });
              //将审核状态置为通过
              this.currentItem.status = STATUS_PASS;
            }
          }
        })
      },

      //拒绝组队申请
      auditReject(item) {
        this.rejectDialogShow = true;
        this.currentItem = item
      },

      //删除数据
      deleteItem(id) {

      },

      submitRejectReason() {
        this.rejectDialogShow = false;
        //将审核状态置为通过
        this.currentItem.status = STATUS_NOT_PASS;
      }

    }
  }
</script>

<style scoped lang="scss">
  @import "../../../../public/scss/index";

  $title-size: 16px;
  $text-size: 14px;

  .apply-container {
    display: flex;
    flex-direction: column;
    background-color: white;
    .item {
      display: flex;
      position: relative;
      align-items: center;
      padding: 16px 10px;
      font-size: $text-size;
      color: $text-main;
      border-bottom: 1px solid $border-fourth;
      &:last-child {
        border-bottom: none;
      }
      .audit-avatar {
        width: 80px;
        height: 80px;
        background-size: cover;
        border-radius: 50%;
      }
      .right-wrapper {
        display: flex;
        flex-direction: column;
        margin-left: 10px;
        .title-wrapper {
          font-size: $title-size;
          color: $text-main;
          cursor: pointer;
          .title {
            margin-right: 10px;
            font-size: 16px;
          }
          .tag {
            font-size: 12px;
            padding: 4px 6px;
            background: $border-third;
            margin-right: 10px;
            font-weight: 500;
          }
        }
        .row1-wrapper {
          display: flex;
          align-items: center;
          .role-wrapper {
            font-size: 14px;
            color: $text-normal;
            padding-top: 10px;
            margin-right: 20px;
            .role {
              color: $text-main;
            }
          }
        }
        .time {
          font-size: 14px;
          color: $text-normal;
          padding-top: 10px;
          .workday {
            margin-right: 10px;
          }
        }
        .remark-wrapper {
          font-size: 14px;
          color: $text-normal;
          padding-top: 10px;
        }
      }
      .btn-wrapper {
        position: absolute;
        right: 20px;
        display: flex;
        align-items: center;
        .delete-btn {
          margin-left: 16px;
        }
      }
    }
  }

  .dialog-content {
    display: flex;
    flex-direction: column;
    .btn-wrapper {
      display: flex;
      align-items: center;
      justify-content: flex-end;
      margin-top: 20px;

    }
  }
</style>
