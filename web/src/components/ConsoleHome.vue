<template>
    <div>
        <el-button @click="onSubmit">下载文件</el-button>
    </div>
</template>

<script>
    export default {
        name: "ConsoleHome",
        methods: {
            onSubmit() {
                console.log('submit!');
                this.axios.get("/api/download").then((res) => {
                    console.log("-----------------")
                    console.log(res.data);
                });
            }
        }
    }
</script>

<style scoped>

</style>