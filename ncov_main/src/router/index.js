import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/main',
    name: 'Main',
    component: () => import('@/views/Main.vue'),
    meta: {
      title: 'Main'
    }
  },
  {
    path: '/china',
    name: 'China',
    component: () => import('@/views/China.vue'),
    meta: {
      title: 'China'
    }
  },
  {
    path: '/beijing',
    name: 'Beijing',
    component: () => import('@/views/Beijing.vue'),
    meta: {
      title: 'Beijing'
    }
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
