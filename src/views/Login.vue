<template>
    <body id="poster">
        <div v-for="item of 500" :key="item" class="snowflake"></div>
        <el-form class="login-container" label-position="left"  label-width="0px">
            <h3 class="login_title">
                系统登陆
                <el-button   @click="toRegister()">点我注册</el-button>
            </h3>
            <el-form-item label="">
                <el-input  type="text" v-model="loginForm.loginName" autocomplete="off" placeholder="账号"></el-input>
            </el-form-item>
                       <el-form-item label="">
                <el-input type="password" v-model="loginForm.password" autocomplete="off" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;background:#505458;border:none" v-on:click="Login()">登陆</el-button>
            </el-form-item>
        </el-form>
    </body>
</template>

<script>

export default {
  name: 'Login',
  data() {
      return {
        loginForm: {
          loginName: '',
          password: ''
        }
      }
    },
    methods: {
      Login() {
        // console.log('submit!',this.loginForm);
        
            this.axios.post('http://localhost:8088/sys-user/login',this.loginForm).then((resp)=>{
                let data = resp.data;
                if(data.success){
                    this.loginForm= {};
                    this.$message({
                    message: '欢迎光临后台管理系统!!!',
                    type: 'success'
                    });
                    this.$router.push({path:'/Homeview'})
                }
            })

      },
      toRegister(){
        this.$router.push({path:'/Register'})
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
        background-image: url(../../public/img/Trust\ You\ 花海-高达00\ Gundam\ 00（高达系列50）4K色彩.jpg);
    }
    body{
        margin:0px;
        padding:0px;
    }
    .login-container{
        border-radius:15px;
        background-clip:padding-box;
        margin:90px auto;
        width:350px;
        padding: 35px 35px 15px 35px;
        background:#fff;
        border:1px solid #eaeaea;
        box-shadow:0 0 25px #cac6c6;
    }
    .login_title{
        margin : 0px auto 40px auto;
        text-align:center;
        color:#505458;
    }
</style>