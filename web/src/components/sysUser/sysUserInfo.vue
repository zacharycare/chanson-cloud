<template>
    <div>系统用户信息</div>
</template>

<script>
    export default {
        name: "sysUserInfo",
        created: function () {
            this.axios({
                method: 'GET',
                url: '/sys-base-data/getUsers'
            }).then(function (response) {
                console.log("=========response===========")
                console.log(response);
            }).catch(function (error) {
                console.log("====error===========");
                console.log(error.response);
            });
        }
    }
</script>

<style scoped>

</style>