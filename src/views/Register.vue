<template>
  <div id="poster">
    <div v-for="item of 500" :key="item" class="snowflake"></div>
    <el-form 
    :model="ruleForm" 
    :rules="rules"
    ref="ruleForm" 
    label-width="0px"
    label-position="left"
     class="register-container">
        <h3 class="register_title">
            系统注册
            <el-button   @click="toLogin()">去登陆</el-button>
        </h3>
    <el-form-item label="" prop="loginName">
        <el-input 
        type="text"
        autocomplete="off"
        v-model="ruleForm.loginName"
        placeholder="请输入用户名"
        prefix-icon="el-icon-user-solid"
        ></el-input>
    </el-form-item>
        <el-form-item label="" prop="name">
        <el-input 
         type="text"
         autocomplete="off"
        v-model="ruleForm.name"
        prefix-icon="el-icon-user-solid"        
        placeholder="请输入网名"></el-input>
    </el-form-item>
    
    <el-form-item label="" prop="password">
        <el-input 
        type="password" 
        v-model="ruleForm.password"
         autocomplete="off"
         placeholder="请输入密码"
          prefix-icon="el-icon-lock"  

         ></el-input>
    </el-form-item>
    <el-form-item label="" prop="checkPass">
        <el-input 
        type="password" 
        v-model="ruleForm.checkPass" 
        placeholder="请输入确认密码"
          prefix-icon="el-icon-lock"  
        autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
        <el-button type="primary" style="background:#505458;border:none" @click="submitForm(ruleForm)">注册</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'Register',
  data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          loginName: '',
          password: '',
          name: '',
          checkPass:""
        },
        rules: {
          loginName: [
            { required: true,message:"请输入你的名称", trigger: 'blur' },
            { min: 2,max:9,message:"长度2到9个字符", trigger: 'blur' }
          ],
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(ruleForm) {

        this.axios.post('http://localhost:8088/sys-user/register',this.ruleForm).then((resp)=>{
            console.log(resp);
            let data = resp.data;
            console.log(data);
            if(data.success){
              this.ruleForm= {};
                this.$message({
                message: '恭喜你,注册成功,点击去登陆按钮进行登陆吧!!!',
                type: 'success'
                });
            }
        })


      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      toLogin(){
         this.$router.push({path:'/'})
      }

    }

}
</script>


<style lang="scss">
body {
		background-color: black;
	}

	.snowflake {
		--size: 1vw;
		width: var(--size);
		height: var(--size);
		background: url(../../public/img/Sakura_magic.png) no-repeat; //雪花图片 也可以画圆
		background-size: 100% 100%;
		position: fixed;
		top: -5vh; //出事高度在屏幕外 效果更真实
		z-index: -10; //背景图层不遮挡上面元素
	}

	@keyframes snowfall {
		100% {
			transform: translate3d(var(--end), 100vh, 0);
		}
	}

	@for $i from 0 through 500 {
		.snowflake:nth-child(#{$i}) {
			//每个雪花的大小
			--size: #{random(6) * 0.08}vw;
			//雪花移动目标点 -70后是负数 这样雪花会向左下方飘落 
			--end: #{random(20) - 70}vw;
			//雪花初始位置 
			left: #{random(150)}vw;
			//雪花从顶到底移动的动画 动画时间可以调整雪花速度
			animation: snowfall #{5 + random(8)}s linear infinite;
			animation-delay: -#{random(10)}s;
		}
	}
    #poster{
        background-position:center;
        height:100%;
        width:100%;
        background-size:cover;
        position:fixed;
        margin:0px;
        padding:0px;        
    }


    .register-container{
        border-radius:15px;
        background-clip:padding-box;
        margin:90px auto;
        width:350px;
        padding: 35px 35px 15px 35px;
        background:#fff;
        border:1px solid #eaeaea;
        box-shadow:0 0 25px #cac6c6;
    }
    .register_title{
        margin : 0px auto 40px auto;
        text-align:center;
        color:#505458;
    }
</style>