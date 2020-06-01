<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <div>
      <router-link to="/about">关于</router-link> |
      <router-link to="/login">登录</router-link>
    </div>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>

<style>
  .home{text-align: center}
</style>