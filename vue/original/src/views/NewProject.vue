<!--新建项目-->
<template>
  <div class="container">
    <div class="content">
      <div class="title">新建项目</div>
      <div class="wrapper">
        <div class="pro-name">
          <div class="subtitle">项目名称</div>
          <el-input class="input"></el-input>
        </div>
        <div class="intro">
          <div class="subtitle">简介</div>
          <el-input class="input" type="textarea" :rows="3" placeholder="简单的介绍下这个项目吧" v-model="intro"></el-input>
        </div>
        <div class="team-cast">
          <div class="subtitle">团队配置</div>
          <div class="team-item" v-for="team in teamCast">
            <el-select v-model="team.role" placeholder="请选择" @change="roleChange(team)">
              <el-option
                  v-for="item in roleInfo"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                  size="small">
              </el-option>
            </el-select>
            <num-count class="numcount" :info="team"></num-count>
            <i class="el-icon-delete" @click="deleteCast(team)"></i>
          </div>
          <div class="addrow" @click="addCast">
            <i class="iconfont icon-add"></i>
            <span class="add-text">添加阵容</span>
          </div>
        </div>
        <div class="your-role">
          <div class="subtitle">你的角色</div>
          <el-select v-model="yourRole" placeholder="请选择" @change="yourRoleChange()">
            <el-option
                v-for="item in roleInfo"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                size="small">
            </el-option>
          </el-select>
        </div>

        <div class="difficulty">
          <div class="subtitle">项目难度</div>
          <el-rate :value="difficulty" show-score text-color="#606266" @change="changeDifficulty"></el-rate>
        </div>

        <div class="period">
          <div class="subtitle">项目周期</div>
          <el-date-picker
              v-model="period"
              type="daterange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
          </el-date-picker>
        </div>

        <div class="cover">
          <div class="subtitle">项目封面</div>
        </div>

        <div class="cover">
          <div class="subtitle">项目截图</div>
        </div>

        <div class="cover">
          <div class="subtitle">附件</div>
        </div>

        <div class="btn-wrapper">
          <el-button class="cancel">取消</el-button>
          <el-button class="submit" type="primary">发布</el-button>
        </div>
      </div>
    </div>

  </div>
</template>

<script>

  import NumCount from '../components/NumCount'
  import CommonUtils from '../utils/CommonUtils'

  const ROLE = [
    {id: 'designer', name: '设计师'},
    {id: 'frontEnd', name: '前端工程师'},
    {id: 'backEnd', name: '后端工程师'},
    {id: 'mobile', name: '移动端工程师'},
    {id: 'game', name: '游戏工程师'},
    {id: 'pm', name: '产品经理'},
  ];

  export default {
    components: {
      "num-count": NumCount
    },
    data() {
      return {
        intro: '',
        //选择的角色
        yourRole: '',
        //角色信息数据源
        roleInfo: ROLE,
        //团队阵容
        teamCast: [{id: new Date().getTime(), role: '', num: 0}],
        //难度
        difficulty: 0,
        //项目周期
        period: ''
      }
    },
    created(){
      console.log("isHome",this.$store.state.isHome)
    },
    methods: {
      roleChange(team) {
        console.log(team)

      },

      //添加团队阵容
      addCast() {
        //id为了区分开每项，用当前时间戳作为值
        this.teamCast.push({id: new Date().getTime(), role: '', num: 0});
        console.log(this.teamCast)
      },

      //删除选中的团队阵容
      deleteCast(team) {
        this.teamCast = CommonUtils.deleteArrayItem(this.teamCast, team);
        console.log(this.teamCast)
      },

      //你的角色选择改变
      yourRoleChange() {

      },

      //难度改变回调
      changeDifficulty(value) {
        this.difficulty = value
      },


    }
  }
</script>

<style scoped lang="scss">
  @import "../../public/scss/index";

  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 10px;
    .content {
      display: flex;
      flex-direction: column;
      width: 80%;
      background-color: #fff;
      .title {
        font-size: 18px;
        font-weight: 700;
        text-align: center;
        padding: 20px;
      }
      .subtitle {
        font-size: 16px;
        font-weight: 700;
        padding: 12px 0;
      }
      .wrapper {
        padding: 20px 40px;
        .intro {
          margin-top: 10px;
        }
        .team-cast {
          margin-top: 10px;
          .team-item {
            display: flex;
            flex-direction: row;
            width: 100%;
            align-items: center;
            padding: 8px 0;
            .numcount {
              margin-left: 30px;
            }
            .el-icon-delete {
              color: $color-danger;
              font-size: 18px;
              margin-left: 50px;
              cursor: pointer;
            }
          }
          .addrow {
            display: flex;
            align-items: center;
            color: $text-normal;
            padding: 10px 0;
            cursor: pointer;
            .icon-add {
              font-size: 20px;
            }
            .add-text {
              font-size: 14px;
              margin-left: 10px;
            }
          }
        }
        .difficulty {
          margin-top: 10px;
        }
        .period {
          margin-top: 10px;
          .date-select {
            display: flex;
            align-items: center;
            .division {
              font-size: 16px;
              color: $text-normal;
              margin: 0 20px;
            }
          }
        }
        .btn-wrapper {
          width: 100%;
          display: flex;
          align-items: center;
          justify-content: center;
          padding: 20px;
          .cancel, .submit {
            width: 20%;
          }
        }
      }
    }

  }
</style>
