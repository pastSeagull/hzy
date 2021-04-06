<template>
    <el-menu :default-active="activeHome" class="el-menu-demo" mode="horizontal" :router="true" @select="handleSelect">
        <el-menu-item index="1">首页</el-menu-item>
        <el-submenu index="2">
            <template slot="title">我的世界</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
            <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项1</el-menu-item>
                <el-menu-item index="2-4-2">选项2</el-menu-item>
                <el-menu-item index="2-4-3">选项3</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-menu-item index="login" >登录</el-menu-item>
        <el-menu-item index="register">注册</el-menu-item>
        <!-- <el-button id="logout_button" v-if="showLoginIn() === false" @click="logout">退出</el-button> -->
    </el-menu>

</template>

<script>
    export default {
        name: "NavMenu",

        data(){
            return{
                activeHome:'/'
            };
        },
        watch: {
            $router(){
                this.setCurrentRoute()
                window.close.log("$route()"+this.activeHome)
            }
        }
    }

</script>

<style scoped>

</style>