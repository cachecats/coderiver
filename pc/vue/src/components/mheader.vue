<template>
  <div class="mheader" :class="{'is-home': isHome}">
    <div class="side"></div>
    <div class="content">
      <div class="content-left">
        <div class="logo">LOGO</div>
        <router-link to="/home" class="tab" :class="{'normal': isHome}">首页</router-link>
        <router-link to="/resource" class="tab" :class="{'normal': isHome}">资源中心</router-link>
        <router-link to="/project" class="tab" :class="{'normal': isHome}">项目中心</router-link>
        <router-link to="/talents" class="tab" :class="{'normal': isHome}">人才广场</router-link>
      </div>
      <div class="content-right">
        <el-button class="create" type="primary" round size="small" @click="createProject">新建项目</el-button>
        <div class="unlogin" v-if="!isLogin">
          <span class="tab" @click="login" :class="{'normal': isHome}">登录</span>
          <span class="tab" @click="register" :class="{'normal': isHome}">注册</span>
        </div>

        <div class="login" v-if="isLogin">
          <img src="../assets/avatar.png" width="32px" height="32px"/>
          <el-popover
              v-model="popoverVisible"
              popper-class="popover"
              placement="bottom"
              width="60"
              trigger="hover">
            <div class="drop" v-for="(item, index) in dropMenu">
              <div class="item" @click="clickDropItem(index)">
                <i class="iconfont" :class="item.font"></i>
                <span class="item-text" style="padding: 10px">{{item.name}}</span>
              </div>
            </div>
            <span class="name" slot="reference" :class="{'normal': isHome}">冷小斩</span>
          </el-popover>
        </div>
      </div>
    </div>
    <div class="side"></div>

    <el-dialog
        title="登录"
        :visible.sync="dialogVisible"
        top="20vh"
        width="30%"
        :append-to-body="true">
      <div class="dialog-wrapper">
        <el-form :model="form" :rules="rules" label-width="0" ref="form">
          <el-form-item prop="emailTel">
            <el-input placeholder="手机号或邮箱" v-model="form.emailTel" clearable autofocus></el-input>
          </el-form-item>
          <el-form-item class="pass" prop="password">
            <el-input placeholder="密码" v-model="form.password" clearable type="password"></el-input>
          </el-form-item>
          <div class="bottom">
            <span class="normal">没有账号？</span>
            <span class="active" @click="goToRegister">立即注册</span>
            <span class="active forget">忘记密码</span>
          </div>
          <div class="btn-wrapper">
            <el-button class="login-btn" type="primary" @click="doLogin">登录</el-button>
            <transition name="fade">
              <div class="error" v-show="pwdError">用户名或密码错误</div>
            </transition>
          </div>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  import {Message} from 'element-ui'
  import CookieUtils from '../utils/CookieUtils'

  export default {
    name: "mheader",
    data() {
      let checkEmailTel = (rule, value, callback) => {
        if (!value || value === '') {
          callback(new Error("请输入电话号或邮箱"))
        } else {
          callback()
        }
      };
      let checkPass = (rule, value, callback) => {
        if (!value || value === '') {
          callback(new Error("请输入密码"))
        } else {
          callback()
        }
      };
      return {
        currentTab: 0,
        dialogVisible: false,
        pwdError: false,
        isLogin: false,
        form: {
          emailTel: '',
          password: '',
        },
        rules: {
          emailTel: [
            {validator: checkEmailTel, trigger: 'blur'}
          ],
          password: [
            {validator: checkPass, trigger: 'blur'}
          ]
        },
        dropMenu: [
          {name: '我的主页', font: 'icon-home'},
          {name: '工作台', font: 'icon-work-station'},
          {name: '退出', font: 'icon-poweroff'}
        ],
        popoverVisible: false

      }
    },
    computed: {
      isHome() {
        return this.$store.state.isHome
      }
    },
    methods: {
      /**
       * 登录，弹出登录框
       */
      login() {
        this.dialogVisible = true
      },

      /**
       * 注册，跳转到注册页面
       */
      register() {
        this.$router.push({name: 'register', params: {msg: 'hahaha'}})
      },

      /**
       * 执行登录
       */
      doLogin() {
        this.pwdError = false;
        this.$refs.form.validate((valid) => {
          if (valid) {
            let params = {
              email: this.form.emailTel,
              password: this.form.password
            };
            this.$api.login(params).then(res => {
              console.log("login---", res);
              let userInfo = res.data;
              // 存入 vuex 中
              this.$store.commit("setUserInfo", userInfo);
              //将 userId 和 token 写入 cookie
              CookieUtils.setCookie("userId", userInfo.id);
              CookieUtils.setCookie("token", userInfo.token);

              this.isLogin = true;
              this.dialogVisible = false
            }).catch(err => {
              console.log("err---", err);
              Message.error(err.data.msg);
              this.pwdError = true;
              return false
            })
          }
        })
      },

      /**
       * 点击下拉列表的某一项
       */
      clickDropItem(index) {
        //隐藏 popover
        this.popoverVisible = false;
        switch (index) {
          case 0:
            console.log("我的主页");
            this.$router.push({name: 'talents_detail'});
            break;
          case 1:
            console.log("工作台");
            this.$router.push({name: 'workstation', params: {flag: "myProject"}});
            break;
          case 2:
            console.log("退出");
            break;
        }
      },

      /**
       * 点击马上注册按钮
       */
      goToRegister() {
        this.dialogVisible = false;
        this.$router.push({name: 'register'})
      },

      //新建项目
      createProject() {
        this.$router.push({name: "newproject", params: {}})
      }

    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  $header-bg-color: #fff;

  .drop {
    .item {
      cursor: pointer;
      padding: 10px;
      font-size: 14px;
      color: #333;
    }
  }

  .mheader {
    display: flex;
    width: 100%;
    height: 80px;
    background-color: $header-bg-color;
    &.is-home {
      background-color: transparent;
    }
    .side {
      flex: 1;
    }
    .content {
      display: flex;
      width: 980px;
      height: 100%;
      align-items: center;
      justify-content: space-between;
      .content-left {
        display: flex;
        height: 100%;
        align-items: center;
        .logo {
          width: 180px;
          height: 60px;
          line-height: 60px;
          background-color: lightblue;
          text-align: center;
          color: #fff;
        }
        .tab {
          width: 100px;
          height: 80px;
          line-height: 80px;
          text-align: center;
          font-size: 16px;
          box-sizing: border-box;
          color: #333;
          &:hover, &.router-link-exact-active {
            border-bottom: 4px solid $color-main;
            color: $color-main;
          }
          &.normal {
            color: #fff;
            &:hover, &.router-link-exact-active {
              border-bottom: none;
            }
          }
        }
      }
      .content-right {
        display: flex;
        height: 100%;
        align-items: center;
        .create {
          margin-right: 20px;
        }
        .unlogin {
          display: flex;
          height: 100%;
          align-items: center;
          .tab {
            width: 60px;
            height: 80px;
            line-height: 80px;
            text-align: center;
            font-size: 16px;
            box-sizing: border-box;
            color: #333;
            &:hover, &.router-link-exact-active {
              cursor: pointer;
              color: $color-main;
            }
            &.normal {
              color: #fff;
              &:hover, &.router-link-exact-active {
                border-bottom: none;
              }
            }
          }
        }
        .login {
          display: flex;
          align-items: center;
          .name {
            margin-left: 10px;
            height: 80px;
            line-height: 80px;
            text-align: center;
            font-size: 16px;
            color: #333;
            cursor: pointer;
            &.normal {
              color: #fff;
            }
          }
        }
      }
    }
  }

  .dialog-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: center;
    .toggleLogin {
      width: 100%;
      text-align: right;
      right: 0;
      color: $color-main;
      font-size: 14px;
      cursor: pointer;
      padding-bottom: 10px;
    }
    .bottom {
      position: relative;
      width: 100%;
      .normal {
        font-size: 14px;
        color: #666;
      }
      .active {
        font-size: 14px;
        color: $color-main;
        cursor: pointer;
        &.forget {
          position: absolute;
          right: 0;
        }
      }
    }
    .btn-wrapper {
      display: flex;
      align-items: center;
      .login-btn {
        width: 30%;
        position: relative;
        left: 0;
        bottom: 0;
        margin-top: 20px;
      }
      .error {
        flex: 1;
        text-align: right;
        color: $color-danger;
        font-size: 14px;
        padding: 10px 0;
      }
      .fade-enter-active, .fade-leave-active {
        transition: opacity 0.5s;
      }
      .fade-enter, .fade-leave-to {
        opacity: 0;
      }
    }
  }
</style>