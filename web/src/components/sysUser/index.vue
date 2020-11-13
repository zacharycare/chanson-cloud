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
                <el-link icon="el-icon-key" type="primary" :underline="false" @click="authorizeClick">授权</el-link>
            </div>
            <el-table :data="dataList" style="width: 100%"  @selection-change="handleSelectionChange">
                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="id" label="ID" width="180"></el-table-column>
                <el-table-column prop="username" label="用户名" width="180"></el-table-column>
                <el-table-column prop="nickName" label="昵称" width="180"></el-table-column>
                <el-table-column prop="tel" label="手机"></el-table-column>
                <el-table-column prop="email" label="邮箱"></el-table-column>
            </el-table>
            <pagination :url="dataUrl" @transferData="loadData"></pagination>
        </el-main>
        <el-dialog title="角色列表" :visible.sync="dialogVisible" @open="loadRole" :destroy-on-close="true">
            <el-table ref="sysRoleMultipleTable" :data="sysRoles" style="width: 100%" row-key="id" @selection-change="handleSelectionRoleChange">
                <el-table-column type="selection" :reserve-selection="true"></el-table-column>
                <el-table-column prop="id" label="ID" width="180"></el-table-column>
                <el-table-column prop="roleCode" label="角色代码" width="180"></el-table-column>
                <el-table-column prop="roleName" label="角色名" width="180"></el-table-column>
                <el-table-column prop="roleDesc" label="角色描述" width="180"></el-table-column>
            </el-table>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="authorizeCommit">确 定</el-button>
             </span>
        </el-dialog>
    </el-container>
</template>

<script>
    import pagination from '../common/pagination';
    export default {
        name: "sysUserInfo",
        components: {
            'pagination': pagination
        },
        data() {
            return {
                dataUrl: '/sys-base-data/sysUser/selectPage',
                dataList: [],
                totalCount: 0,
                multipleSelection: [],
                dialogVisible: false,
                sysRoles: [],
                multipleRoleSelection: []
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
                this.$router.push({name:'sysUserEdit',params: this.multipleSelection[0]})
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
                    url: '/sys-base-data/sysUser/delete',
                    data: JSON.stringify(ids)
                }).then(function (response) {
                    console.log("=========response===========")
                    console.log(response);
                }).catch(function (error) {
                    console.log("====error===========");
                    console.log(error.response);
                });
            },
            loadRole() {
                const _this = this;
                this.axios.post("/sys-base-data/sysUser/selectAllSysRoleAndChecked",{id: this.multipleSelection[0].id}).then(function (response) {
                    _this.sysRoles = response.data;
                    _this.sysRoles.forEach(sysRole => {
                        if (sysRole.sysUserId === _this.multipleSelection[0].id) {
                            _this.$refs.sysRoleMultipleTable.toggleRowSelection(sysRole, true);
                        }
                    })
                });
            },
            loadData(data) {
                this.dataList = data;
            },
            authorizeClick() {
                if (this.multipleSelection.length !== 1) {
                    this.$message.error('请选择一条记录进行授权');
                    return;
                }
                this.dialogVisible = true;
            },
            handleSelectionRoleChange(val) {
                console.log("选择角色")
                console.log(val)
                this.multipleRoleSelection = val;
            },
            authorizeCommit() {
                console.log("确定授权");
                this.axios({
                    method: 'POST',
                    url: '/sys-base-data/sysUser/authorizeSysRole',
                    data: JSON.stringify({
                        sysUserId: this.multipleSelection[0].id,
                        authorities: this.multipleRoleSelection
                    })
                }).then(function (response) {
                    console.log("=========response===========")
                    console.log(response);
                }).catch(function (error) {
                    console.log("====error===========");
                    console.log(error.response);
                });
                this.dialogVisible = false;
            }
        }
    }
</script>

<style scoped>
    @import "../../css/common.css";
</style>