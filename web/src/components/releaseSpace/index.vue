<template>
    <el-container>
        <el-header>
            <span>此处查询条件</span>
        </el-header>
        <el-main>
            <div class="toolbar">
                <el-link icon="el-icon-plus" type="primary" :underline="false" href="releaseSpaceEdit">新增</el-link>
                <el-link icon="el-icon-edit" :underline="false" @click="editSelected">编辑</el-link>
                <el-link icon="el-icon-delete" type="danger" :underline="false" @click="deleteSelected">删除</el-link>
            </div>
            <el-table :data="dataList" style="width: 100%"  @selection-change="handleSelectionChange">
                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="name" label="空间名称" width="180"></el-table-column>
                <el-table-column prop="code" label="空间代码" width="180"></el-table-column>
                <el-table-column prop="address" label="地址"></el-table-column>
                <el-table-column prop="remark" label="备注"></el-table-column>
            </el-table>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "releaseSpaceIndex",
        data() {
            return {
                dataList: [],
                totalCount: 0,
                multipleSelection: []
            }
        },
        created: function () {
            this.onLoad();
        },
        methods: {
            onLoad() {
                console.log("onLoad------------------");
                let _this = this;
                this.axios({
                    method: 'POST',
                    url: '/release/space/list'
                }).then(function (response) {
                    console.log("=========response===========")
                    console.log(response);
                    _this.dataList = response.data.data;
                }).catch(function (error) {
                    console.log("====error===========");
                    console.log(error.response);
                });
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            editSelected() {
                if (this.multipleSelection.length !== 1) {
                    this.$message.error('请选择一条记录进行编辑');
                    return;
                }
                this.$router.push({name:'releaseSpaceEdit',params: this.multipleSelection[0]})
            },
            deleteSelected() {
                let _this = this;
                if (this.multipleSelection.length !== 1) {
                    this.$message.error('请选择一条记录进行删除');
                    return;
                }
                this.axios({
                    method: 'POST',
                    url: '/release/space/delete',
                    data: this.multipleSelection[0]
                }).then(function (response) {
                    console.log(response);
                    if (response.data.data === true) {
                        console.log("===============================");
                        _this.onLoad();
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    }
</script>

<style scoped>
    @import "../../css/common.css";
</style>