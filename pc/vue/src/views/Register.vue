<!--注册页面-->
<template>
  <div class="register">
    <el-form :model="form" status-icon :rules="rules" ref="form" label-width="80px">
      <el-form-item label="邮箱" prop="email">
        <el-input type="email" v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="form.password" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="form.checkPass" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="昵称" prop="nickname">
        <el-input v-model="form.nickname"></el-input>
      </el-form-item>
      <el-form-item label="验证码">
        <el-input v-model="form.verify"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" :loading="loading" @click="onSubmit">注册</el-button>
        <el-button type="default" @click="resetData">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

  import CommonUtils from '@/utils/CommonUtils'

  export default {
    components: {},
    data() {
      let verifyEmail = (rule, value, callback) => {
        if (value === '') {
          callback(new Error("请输入邮箱"))
        } else {
          if(CommonUtils.checkEmail(value)){
            callback()
          }else{
            callback(new Error("邮箱格式不正确"))
          }
        }
      };
      let verifyPass = (rule, value, callback) => {
        if (!value || value === '') {
          callback(new Error("请输入密码"))
        } else {
          if (this.form.checkPass !== '') {
            this.$refs.form.validateField('checkPass')
          }
          callback();
        }
      };
      let verifyRepass = (rule, value, callback) => {
        if (!value || value === '') {
          callback(new Error("请再次输入密码"))
        } else if (this.form.password !== value) {
          callback(new Error("两次输入密码不一致!"))
        } else {
          callback()
        }
      };
      let verifyNickname = (rule, value, callback) => {
        if (!value || value === '') {
          callback(new Error("请输入昵称"))
        }else{
          callback()
        }
      };

      return {
        form: {
          email: '',
          password: '',
          checkPass: '',
          nickname: '',
          verify: ''
        },
        rules: {
          email: [
            {validator: verifyEmail, trigger: 'blur'}
          ],
          password: [
            {validator: verifyPass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: verifyRepass, trigger: 'blur'}
          ],
          nickname: [
            { validator: verifyNickname, trigger: 'blur'}
          ]
        },
        loading: false
      }
    },
    created() {
      console.log(this.$route.params.msg)
    },
    methods: {

      onSubmit() {

        this.$refs.form.validate((valid) => {
          if(valid){
            console.log("submit");
            console.log(this.form);
            this.doRegister()
          }else{
            console.log('no pass')
            return false
          }
        })
      },

      resetData(){
        this.$refs.form.resetFields()
      },

      doRegister(){
        this.loading = true;
        let params = {
          email: this.form.email,
          password: this.form.password,
          name: this.form.nickname
        };
        console.log("params: ", params);
        this.$api.register(params).then(res => {
          this.loading = false;
          console.log(res)
        }).catch(err => {
          this.loading = false;
          console.log(err)
        })
      }
    }
  }
</script>

<style scoped lang="scss">

  @import "../../public/scss/index";

  .register {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    padding-top: 30px;
    @include main-wrapper
  }

</style>
