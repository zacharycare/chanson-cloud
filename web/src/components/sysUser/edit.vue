<template>
    <el-form :model="infoForm" ref="infoForm" :rules="infoRules" :label-position="labelPosition" label-width="80px">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="infoForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="infoForm.password"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input v-model="infoForm.email"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('infoForm')">立即创建</el-button>
            <el-button @click="resetForm('infoForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "sysUserEdit",
        data() {
            return {
                labelPosition: 'left',
                infoForm: {
                    username: '',
                    password: '',
                    email: ''
                },
                infoRules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '请输入用户邮箱', trigger: 'blur' },
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.axios({
                            method: 'POST',
                            url: '/sys-base-data/save',
                            data: JSON.stringify(this.infoForm)
                        }).then(function (response) {
                            console.log(response);
                        }).catch(function (error) {
                            console.log(error);
                        });
                    } else {
                        console.log("no validate");
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>