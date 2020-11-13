<template>
    <el-container>
        <el-header>
            <span>此处查询条件</span>
        </el-header>
        <el-main>
            <div class="toolbar">
                <el-link icon="el-icon-plus" type="primary" :underline="false" href="sysRoleEdit">新增</el-link>
                <el-link icon="el-icon-edit" :underline="false" @click="editSelected">编辑</el-link>
                <el-link icon="el-icon-delete" type="danger" :underline="false" @click="deleteSelected">删除</el-link>
            </div>
            <el-table :data="dataList" style="width: 100%"  @selection-change="handleSelectionChange">
                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="id" label="ID" width="180"></el-table-column>
                <el-table-column prop="roleCode" label="角色代码" width="180"></el-table-column>
                <el-table-column prop="roleName" label="角色名" width="180"></el-table-column>
                <el-table-column prop="roleDesc" label="角色描述" width="180"></el-table-column>
                <el-table-column prop="status" label="状态"></el-table-column>
            </el-table>
            <pagination :url="dataUrl" @transferData="loadData"></pagination>
        </el-main>
    </el-container>
</template>

<script>
    import pagination from '../common/pagination';
    export default {
        name: "sysRoleInfo",
        components: {
            'pagination': pagination
        },
        data() {
            return {
                dataUrl: '/sys-base-data/sysRole/selectPage',
                dataList: [],
                totalCount: 0,
                multipleSelection: []
            }
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
                this.$router.push({name:'sysRoleEdit',params: this.multipleSelection[0]})
            },
            deleteSelected() {
                if (this.multipleSelection.length < 1) {
                    this.$message.error('请至少选择一条记录进行删除');
                    return;
                }
                let ids = [];
                for (let i = 0;i < this.multipleSelection.length;i++) {
                    ids.push(this.multipleSelection[i].id);
                }
                // const _this = this;
                this.axios({
                    method: 'POST',
                    url: '/sys-base-data/sysRole/delete',
                    data: JSON.stringify(ids)
                }).then(function (response) {
                    console.log("=========response===========")
                    console.log(response);
                }).catch(function (error) {
                    console.log("====error===========");
                    console.log(error.response);
                });
            },
            loadData(data) {
                this.dataList = data;
            }
        }
    }
</script>

<style scoped>
    @import "../../css/common.css";
</style>