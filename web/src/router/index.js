import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
    {
      path: '/login',
      name: 'Login',
      component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
    },
    {
      path: '/console',
      name: 'Console',
      component: () => import(/* webpackChunkName: "about" */ '../views/Console.vue'),
      children: [
        {
          path: '',
          name: 'ConsoleHome',
          component: () => import(/* webpackChunkName: "about" */ '../components/ConsoleHome.vue')
        },
        {
          path: 'sysUserSave',
          name: 'sysUserSave',
          component: () => import(/* webpackChunkName: "about" */ '../components/sysUser/save.vue')
        },
        {
          path: 'sysUserInfo',
          name: 'sysUserInfo',
          component: () => import(/* webpackChunkName: "about" */ '../components/sysUser/sysUserInfo.vue')
        },
        {
          path: 'releaseSpaceIndex',
          name: 'releaseSpaceIndex',
          component: () => import(/* webpackChunkName: "about" */ '../components/releaseSpace/index')
        },
        {
          path: 'releaseSpaceEdit',
          name: 'releaseSpaceEdit',
          component: () => import(/* webpackChunkName: "about" */ '../components/releaseSpace/edit')
        }
      ]
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
