<template>
    <div id="login" class="login">
        <el-form ref="form" :model="form" label-width="80px" style="width: 400px">
            <el-form-item label="用户名">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                form: {
                    name: '',
                    password: ''
                }
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
                let _this = this;
                this.axios({
                    method: 'POST',
                    url: '/auth-center/oauth/token?grant_type=password&username=' + this.form.name + '&password=' + this.form.password + '&scope=all',
                    // headers: {'Authorization': 'Basic c3lzLWJhc2UtZGF0YTp1c2VyLXNlY3JldC04ODg4'},
                    auth: {
                        username: 'sys-base-data',
                        password: 'user-secret-8888'
                    }
                }).then(function (response) {
                    console.log("=========response===========")
                    console.log(response);
                    localStorage.setItem("access_token", response.data.access_token);
                    _this.$router.push("/console");
                }).catch(function (error) {
                    console.log("====error===========");
                    console.log(error.response);
                    _this.$message.error(error.response.data.error_description);
                });
            }
        }
    }
</script>

<style>
    .login {
        display: flex;
        justify-content: center;
    }
</style>