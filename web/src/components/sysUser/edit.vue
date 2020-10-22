<template>
    <el-form :model="infoForm" ref="infoForm" :rules="infoRules" :label-position="labelPosition" label-width="80px">
        <span v-show="isEdit">编辑中...</span>
        <el-input v-model="infoForm.id" v-show="false"></el-input>
        <el-form-item label="用户名" prop="username">
            <el-input v-model="infoForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" v-if="!isEdit">
            <el-input v-model="infoForm.password"><el-button slot="append" @click="initPassword">使用初始密码</el-button></el-input>
        </el-form-item>
        <el-form-item label="昵称" prop="nickName">
            <el-input v-model="infoForm.nickName"></el-input>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
            <el-date-picker v-model="infoForm.birthday" type="date" placeholder="选择日期" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
            <el-radio v-model="infoForm.gender" label="1">男</el-radio>
            <el-radio v-model="infoForm.gender" label="2">女</el-radio>
            <el-radio v-model="infoForm.gender" label="3">未知</el-radio>
        </el-form-item>
        <el-form-item label="手机号" prop="tel">
            <el-input v-model="infoForm.tel"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input v-model="infoForm.email"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('infoForm')">保存</el-button>
            <el-button @click="resetForm('infoForm')">重置</el-button>
            <el-popconfirm
                    title="这是一段内容确定删除吗？"
            >
                <el-button slot="reference">删除</el-button>
            </el-popconfirm>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "sysUserEdit",
        data() {
            return {
                labelPosition: 'right',
                isEdit: false,
                infoForm: {
                    id: null,
                    username: '',
                    password: '',
                    nickName: '',
                    birthday: '',
                    gender: '',
                    tel: '',
                    email: '',
                    registerSource: 'system'
                },
                infoRules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    gender: [
                        { required: true, message: '请选择性别', trigger: 'blur' }
                    ],
                    tel: [
                        { required: true, message: '请输入用户手机号', trigger: 'blur' },
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                let _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.axios({
                            method: 'POST',
                            url: '/sys-base-data/save',
                            data: JSON.stringify(this.infoForm)
                        }).then(function (response) {
                            console.log(response);
                            _this.$message.success(response.data.message);
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
            },
            initPassword() {
                this.infoForm.password = '1234';
            }
        },
        created: function () {
            //编辑时去掉密码更新
            if (this.$route.params.id) {
                this.isEdit = true;
                this.$route.params.password = null;
            }
            this.infoForm = this.$route.params;
        }
    }
</script>

<style scoped>

</style>