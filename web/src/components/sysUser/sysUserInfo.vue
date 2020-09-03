<template>
    <el-container>
        <el-header>
            <span>此处查询条件</span>
        </el-header>
        <el-main>
            <div class="toolbar">
                <el-link icon="el-icon-plus" type="primary" :underline="false" href="sysUserEdit">新增</el-link>
                <el-link icon="el-icon-edit" :underline="false" @click="editSelected">编辑</el-link>
                <el-link icon="el-icon-delete" type="danger" :underline="false" @click="deleteSelected">删除</el-link>
            </div>
            <el-table :data="dataList" style="width: 100%"  @selection-change="handleSelectionChange">
                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="username" label="用户名" width="180"></el-table-column>
                <el-table-column prop="nickName" label="昵称" width="180"></el-table-column>
                <el-table-column prop="tel" label="手机"></el-table-column>
                <el-table-column prop="email" label="邮箱"></el-table-column>
            </el-table>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "sysUserInfo",
        data() {
            return {
                dataList: [],
                totalCount: 0,
                multipleSelection: []
            }
        },
        created: function () {
            const _this = this;
            this.axios({
                method: 'GET',
                url: '/sys-base-data/getUsers'
            }).then(function (response) {
                console.log("=========response===========")
                console.log(response);
                _this.dataList = response.data;
            }).catch(function (error) {
                console.log("====error===========");
                console.log(error.response);
            });
        },
        methods: {
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            editSelected() {
                if (this.multipleSelection.length !== 1) {
                    this.$message.error('请选择一条记录进行编辑');
                    return;
                }
                this.$router.push({name:'sysUserEdit',params: this.multipleSelection[0]})
            },
            deleteSelected() {

            }
        }
    }
</script>

<style scoped>
    @import "../../css/common.css";
</style>