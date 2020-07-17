<template>
    <el-form :model="infoForm" ref="infoForm" :rules="infoRules" :label-position="labelPosition" label-width="80px">
        <el-form-item label="空间名称" prop="name">
            <el-input v-model="infoForm.name"></el-input>
        </el-form-item>
        <el-form-item label="空间代码" prop="code">
            <el-input v-model="infoForm.code"></el-input>
        </el-form-item>
        <el-form-item label="空间地址" prop="address">
            <el-input v-model="infoForm.address"></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
            <el-input v-model="infoForm.remark"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('infoForm')">立即保存</el-button>
            <el-button @click="resetForm('infoForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "releaseSpaceEdit",
        data() {
            return {
                labelPosition: 'left',
                infoForm: {
                    name: '',
                    code: '',
                    address: '',
                    remark: ''
                },
                infoRules: {
                    name: [
                        { required: true, message: '请输入空间名称', trigger: 'blur' }
                    ],
                    code: [
                        { required: true, message: '请输入空间代码', trigger: 'blur' },
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
                            url: '/release/space/save',
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
        },
        created: function () {
            console.log("================");
            console.log(this.$route.params);
            this.infoForm = this.$route.params;
        }
    }
</script>

<style scoped>

</style>