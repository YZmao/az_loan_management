<template>
    <!-- 主容器 -->
    <el-container class="main-class">
        <!-- 头部信息 -->
        <el-header>
            <el-row >
                <!-- 头像 -->
                <el-col :span="2">
                    <el-avatar :size="60" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"/>
                </el-col>
                <!-- 项目名称 -->
                <el-col :span="15"   class="title">
                    Az贷后管理后台系统 <span>———— 管理员({{ name }} )  </span>
                </el-col>
                <!-- 退出按钮-->
                <el-col :span="7" class="logout">
                    <el-button type="info">退出登录</el-button>
                </el-col>
                <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
            </el-row>
            
        </el-header>
        <!-- 主体容器 -->
        <el-container>
            <!-- 侧边栏 -->
            <el-aside width="150px">
                <el-menu
                    default-active="2"
                    class="el-menu-vertical-demo"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b">
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>导航一</span>
                        </template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="1-1">选项1</el-menu-item>
                            <el-menu-item index="1-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="1-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="1-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="1-4-1">选项1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-menu-item index="2">
                        <i class="el-icon-menu"></i>
                        <span slot="title">导航二</span>
                    </el-menu-item>
                    <el-menu-item index="3" disabled>
                        <i class="el-icon-document"></i>
                        <span slot="title">导航三</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title">导航四</span>
                    </el-menu-item>
                </el-menu>
                
            </el-aside>
            <!-- 主体 -->
            <el-main>
                <el-breadcrumb separator-class="el-icon-arrow-right">
                    <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item>活动管理</el-breadcrumb-item>
                    <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                    <el-breadcrumb-item>活动详情</el-breadcrumb-item>
                </el-breadcrumb>
                <span class="main-title">  后台管理系统  </span>
            </el-main>
        </el-container>
    </el-container>
</template>



<script>

export default {
    
    data(){
        return{
            name : "系统管理员"
        }
    }
    
}

</script>

<style scoped>
    /* scoped受保护的样式 */
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    
    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }
    
    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }
    /* 主容器样式 */
    .main-class {
        height: 100%;
        margin: 0;
        padding: 0;
    }

    .title{
        text-align: left;
        font-size: 25px;
        font-family: sans-serif;
    }
    .logout{
        text-align: right;
    }

    .main-title{
        font-size: 50px;
        font-family: sans-serif;
    }
</style>