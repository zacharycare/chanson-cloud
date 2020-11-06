<template>
    <el-container>
        <el-header>
            <el-avatar fit="fill" :size="60" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
            <el-menu class="el-menu-top" mode="horizontal">
                <el-menu-item index="1">处理中心</el-menu-item>
                <el-submenu index="2">
                    <template slot="title">我的工作台</template>
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
                <el-menu-item index="3" disabled>消息中心</el-menu-item>
                <el-menu-item index="4" @click="logout">
                    退出
                </el-menu-item>
            </el-menu>
        </el-header>
        <el-container>
            <el-menu class="el-menu-vertical" router>
                <el-menu-item index="1" :route="{name: 'ConsoleHome'}">
                    <i class="el-icon-s-home"></i>
                    <span slot="title">首页</span>
                </el-menu-item>
                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-user-solid"></i>
                        <span slot="title">系统管理</span>
                    </template>
                    <el-menu-item index="2-1" :route="{name: 'sysUserInfo'}">用户管理</el-menu-item>
                    <el-menu-item index="2-2" :route="{name: 'sysUserEdit'}">保存用户</el-menu-item>
                    <el-menu-item index="2-3" :route="{name: 'sysRoleInfo'}">角色管理</el-menu-item>
                    <el-menu-item index="2-4" :route="{name: 'sysRoleEdit'}">保存角色</el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-office-building"></i>
                        <span slot="title">租赁管理</span>
                    </template>
                    <el-menu-item index="3-1" :route="{name: 'releaseSpaceIndex'}">空间资源</el-menu-item>
                    <el-menu-item index="3-2" :route="{name: 'releaseSpaceEdit'}">空间编辑</el-menu-item>
                </el-submenu>
                <el-menu-item index="3" disabled>
                    <i class="el-icon-document"></i>
                    <span slot="title">导航三</span>
                </el-menu-item>
            </el-menu>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Console",
        methods: {
            logout() {
                let _this = this;
                this.axios.get("/auth-center/sys-user/removeToken?accessToken=" + localStorage.getItem("access_token")).then(function (response) {
                    // handle success
                    if (response.data === true) {
                        _this.$router.push("/login");
                    }
                    console.log(response);
                })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    });
            }
        }
    }
</script>

<style scoped>
    .el-container {
        height: 100%;
    }

    .el-menu-top {
        border-bottom-width: 0;
        float: right;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        /*text-align: center;*/
        /*line-height: 160px;*/
        height: 100%;
    }

    .el-menu-vertical {
        width: 200px;
    }
</style>