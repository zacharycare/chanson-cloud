"use strict";

import Vue from 'vue';
import axios from "axios";
import router from "@/router";

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
axios.defaults.baseURL = process.env.NODE_ENV === 'development' ? '/api' : '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';

let config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
};

const _axios = axios.create(config);
// 在实例已创建后修改默认值
// _axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("access_token");
_axios.interceptors.request.use(
  function(config) {
    // Do something before request is sent
    config.headers['Authorization'] = "Bearer " + localStorage.getItem("access_token");
    console.log(localStorage.getItem("access_token"));
    return config;
  },
  function(error) {
    // Do something with request error
    return Promise.reject(error);
  }
);

// Add a response interceptor
_axios.interceptors.response.use(
  function(response) {
    // Do something with response data
    console.log("interceptor data...");
    return response;
  },
  function(error) {
    // Do something with response error
    console.log("interceptor error...");
    console.log(error.response);
    if (error.response && (error.response.status === 401) && (error.response.statusText === 'Unauthorized')) {
      console.log("401...");
      router.replace({
        path: '/login',
        // query: {
        //   redirect: router.currentRoute.fullPath
        // }
      });
    }
    return Promise.reject(error);
  }
);

// eslint-disable-next-line no-unused-vars
Plugin.install = function(Vue, options) {
  Vue.axios = _axios;
  window.axios = _axios;
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios;
      }
    },
    $axios: {
      get() {
        return _axios;
      }
    },
  });
};

Vue.use(Plugin)

export default Plugin;
