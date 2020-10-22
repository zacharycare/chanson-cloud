<template>
    <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="current"
            :page-sizes="[10, 20, 30]"
            :page-size="pageSize"
            background
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
    </el-pagination>
</template>

<script>
    export default {
        name: "pagination",
        data: function() {
            return {
                current: 1,
                pages: 0,
                pageSize: 10,
                total: 0,
                dataList: []
            }
        },
        props: ['url'],
        created: function () {
            this.loadData();
        },
        methods: {
            handleSizeChange(val) {
                this.pageSize = val;
                this.loadData();
            },
            handleCurrentChange(val) {
                this.current = val;
                this.loadData();
            },
            loadData() {
                const _this = this;
                this.axios({
                    method: 'POST',
                    url: '/sys-base-data/sysUser/selectPage',
                    data: {
                        current: this.current,
                        pageSize: this.pageSize
                    }
                }).then(function (response) {
                    _this.dataList = response.data.records;
                    _this.pages = response.data.pages;
                    _this.total = response.data.total;
                    _this.$emit('transferData', _this.dataList);
                }).catch(function (error) {
                    console.log("====error===========");
                    console.log(error.response);
                });
            }
        }
    }
</script>

<style scoped>

</style>