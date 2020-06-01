import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

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
          path: 'menu1',
          name: 'Menu1',
          component: () => import(/* webpackChunkName: "about" */ '../components/Menu1.vue')
        },
        {
          path: 'menu2',
          name: 'Menu2',
          component: () => import(/* webpackChunkName: "about" */ '../components/Menu2.vue')
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
