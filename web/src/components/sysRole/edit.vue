<template>
    <el-form :model="infoForm" ref="infoForm" :rules="infoRules" :label-position="labelPosition" label-width="80px">
        <span v-show="isEdit">编辑中...</span>
        <el-input v-model="infoForm.id" v-show="false"></el-input>
        <el-form-item label="角色代码" prop="roleCode">
            <el-input v-model="infoForm.roleCode" placeholder="ROLE_***"></el-input>
        </el-form-item>
        <el-form-item label="角色名" prop="roleName">
            <el-input v-model="infoForm.roleName"></el-input>
        </el-form-item>
        <el-form-item label="角色描述" prop="roleDesc">
            <el-input v-model="infoForm.roleDesc"></el-input>
        </el-form-item>
        <el-form-item label="状态" prop="status">
            <el-radio v-model="infoForm.status" label="1">启用</el-radio>
            <el-radio v-model="infoForm.status" label="2">禁用</el-radio>
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
        name: "sysRoleEdit",
        data() {
            return {
                labelPosition: 'right',
                isEdit: false,
                infoForm: {
                    id: null,
                    roleCode: '',
                    roleName: '',
                    roleDesc: '',
                    status: ''
                },
                infoRules: {
                    roleCode: [
                        { required: true, message: '请输入角色代码，请以“ROLE_”开头', trigger: 'blur' }
                    ],
                    roleName: [
                        { required: true, message: '请输入角色名', trigger: 'blur' }
                    ],
                    status: [
                        { required: true, message: '请选择状态', trigger: 'blur' }
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
                            url: '/sys-base-data/sysRole/save',
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
            }
        },
        created: function () {
            //编辑时去掉密码更新
            if (this.$route.params.id) {
                this.isEdit = true;
                this.infoForm = this.$route.params;
            }
        }
    }
</script>

<style scoped>

</style>