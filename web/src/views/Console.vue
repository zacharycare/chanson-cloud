<template>
    <el-container>
        <el-header>Header<el-link type="primary" :underline="false" @click="logout">退出</el-link></el-header>
        <el-container>
            <el-menu class="el-menu-vertical" router>
                <el-submenu index="5">
                    <template slot="title">
                        <i class="el-icon-menu"></i>
                        <span slot="title">用户管理</span>
                    </template>
                    <el-menu-item index="5-1" :route="{name: 'sysUserInfo'}">用户管理</el-menu-item>
                    <el-menu-item index="5-2" :route="{name: 'sysUserSave'}">保存用户</el-menu-item>
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
                this.axios.get("/auth-center/sys-user/removeToken?accessToken=" + localStorage.getItem("access_token")).then(function (response) {
                    // handle success
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

    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        /*line-height: 60px;*/
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        /*line-height: 200px;*/
        height: 100%;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        /*line-height: 160px;*/
        height: 100%;
    }

    .el-menu-vertical {
        width: 200px;
    }
</style>