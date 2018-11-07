<!--我的项目-->
<template>
  <div class="container">
    <div class="item" v-for="(item, index) in list">
      <div class="left">
        <img :src="item.avatar" width="90" height="60"/>
      </div>
      <div class="right">
        <div class="row1">
          <span class="title" @click="goToDetail(item)">{{item.name}}</span>
        </div>
        <div class="text">
          简介：{{item.introduce}}
        </div>
        <div class="steps">
          <span class="step">进度：</span>
          <r-step :step="item.schedule"></r-step>
        </div>
      </div>
      <div class="btn" v-show="type === 'created'">
        <el-button type="default" @click="updateProgress(item)" size="small">更新进度</el-button>
        <el-button type="primary" @click="updateProject(item)" size="small">修改</el-button>
        <el-button type="danger" @click="deleteProject(item)" size="small">删除</el-button>
      </div>
      <div class="btn" v-show="type === 'join'">
        <el-button type="danger" @click="quitProject(item)" size="small">退出</el-button>
      </div>
    </div>

    <el-dialog
        title="更新进度"
        :visible.sync="updateProgressShow"
        top="20vh"
        width="50%"
        :append-to-body="true">
      <div class="progress-wrapper">
        <div class="progress-row1">
          <span class="label-text">选择进度</span>
          <el-select v-model="currentProgress" placeholder="请选择" @change="updateProgress">
            <el-option
                v-for="item in progressData"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                size="small">
            </el-option>
          </el-select>
        </div>

        <div class="btn-wrapper">
          <el-button type="default" @click="() => {this.updateProgressShow = false}">取消</el-button>
          <el-button type="primary" @click="confirmUpdateProgress">确定</el-button>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  import {ListData} from '../../../mock/MyProject'
  import RStep from '../../../components/RStep'

  let ProgressData = [
    {id: 1, name: '组队'},
    {id: 2, name: '设计'},
    {id: 3, name: '开发'},
    {id: 4, name: '完成'},
  ];

  export default {
    props: {
      list: {
        type: Array
      },
      type: {
        type: String
      }
    },
    components: {
      "r-step": RStep
    },
    data() {
      return {
        updateProgressShow: false,
        currentProgress: '',
        progressData: ProgressData
      }
    },
    computed: {

    },
    methods: {
      goToDetail(item) {
        this.$router.push({name: 'project_detail'})
      },

      //更新进度
      updateProgress() {
        this.updateProgressShow = true
      },

      //确定更新进度
      confirmUpdateProgress() {
        this.updateProgressShow = false
      },

      //修改
      updateProject(item) {
        this.$router.push({name: 'newproject'})
      },

      //删除
      deleteProject(item) {
        this.$confirm("确定要删除此项目吗？", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功'
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        })
      },

      //退出项目
      quitProject(item){
        this.$confirm(`确定要退出项目 ${item.name} 吗？`, "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '退出成功'
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消'
            });
          });
        })
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../../../public/scss/index";

  .container {
    width: 100%;
    display: flex;
    flex-direction: column;
    .item {
      display: flex;
      position: relative;
      align-items: center;
      padding: 20px;
      box-sizing: border-box;
      background: white;
      border-bottom: 1px solid $border-fourth;
      .left {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
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
        }
        .text {
          width: 400px;
          font-size: 14px;
          color: $text-normal;
          padding-top: 10px;
          white-space: nowrap;
          text-overflow: ellipsis;
          overflow: hidden;
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
        padding-right: 20px;
      }
    }
  }

  .progress-wrapper {
    display: flex;
    flex-direction: column;
    .progress-row1 {
      display: flex;
      flex-direction: row;
      align-items: center;
      .label-text {
        margin-right: 20px;
        color: $text-main;
      }
    }
    .btn-wrapper {
      display: flex;
      width: 100%;
      justify-content: flex-end;
      margin-top: 20px;
    }
  }

</style>
