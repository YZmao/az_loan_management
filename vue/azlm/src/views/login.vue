<template>
    <div class="login_container">
        <div class="login_box">
            <div class="avatar_box">
                <!--头像-->
                <img src="../assets/logo.png" alt />
            </div>
            <!--添加表单-->
            <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules" class="login_form" label-width="0px">
                <el-form-item prop="username">
                    <el-input v-model="loginForm.username" class="login-madia" prefix-icon="iconfont icon-user"  placeholder="请输入用户名"/>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" class="login-madia" prefix-icon="iconfont icon-zi" type="password"  placeholder="请输入密码"/>
                </el-form-item>
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">登录</el-button>
                    <el-button type="info" @click="resetLoginForm">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
//初始化菜单
import store from '@/store';

export default {
    name: 'Login',
    data() {
        return {
            //表单数据
            loginForm: {
                username: '',
                password: ''
            },
            //校验规则
            loginRules: {
                username: [
                    { required: true, message: "请输入用户名", trigger: "blur" },
                    { min: 2, max: 8, message: "长度在 2 到 8 个字符", trigger: "blur" }
                ],
                password: [
                    { required: true, message: "请输入密码", trigger: "blur" },
                    { min: 6, max: 8, message: "密码为 6~8 位", trigger: "blur" }
                ]
            }
        }
    },
    /** 页面加载函数 */
    created() {
    },
    /** 存放页面所有方法 */
    methods: {
        /** 重置表单 */
        resetLoginForm() {
            //充值数据，并清空校验警告
            this.$refs.loginFormRef.resetFields();
        },
        /** 提交登录 */
        login() {
            //表单验证
            this.$refs.loginFormRef.validate((valid) => {
                if(!valid) {
                    return this.$message.error('数据校验未通过，请仔细填写信息！');
                }
                //数据校验成功，就向后端发送校验请求
            });
        }
    }
}
</script>

<!-- 加上 "scoped" 该样式只在当前组件有效 -->
<style lang="less" scoped>
// 跟节点样式
.login_container {
    height: 100%;
}
// 登录框
.login_box {
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;// 圆角
    position: absolute;// 绝对定位
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);// 根据自己位置 以自己为长度位移
    // 头像框
    .avatar_box {
        width: 130px;
        height: 130px;
        box-shadow: 0 0 2px #ddd;// 盒子阴影
        position: absolute;
        left: 50%;
        transform: translate(-50%, -50%);
        img {
            width: 100%;
            height: 100%;
            background-color: white;
        }
    }
    .btns {
        display: flex;// 弹性布局
        justify-content: flex-end; // 尾部对齐
    }
    .login_form {
        position: absolute;
        bottom: 0%;
        width: 100%;
        padding: 0 10px;
        box-sizing: border-box;// 设置边框
    }
}
@media screen and (max-width: 500px) {
    .login_box {
        width: 100%;
    }
    .login_form {
        width: 80% !important;
        margin-left: 12% !important;
    }
    .avatar_box {
        width: 90px !important;
        height: 90px !important;
        margin-top: 50px !important;
    }
}
</style>
