<template>
    <el-form :model="infoForm" ref="infoForm" :rules="infoRules" :label-position="left" label-width="80px">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="infoForm.username"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input v-model="infoForm.email"></el-input>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "sysUserSave",
        data() {
            return {
                infoForm: {
                    username: '',
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
                this.$ref[formName].validate((valid) => {
                    if (valid) {
                        alert("submit success");
                    } else {
                        console.log("no validate");
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>

</style>