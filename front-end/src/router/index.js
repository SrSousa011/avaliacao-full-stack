import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/CreateAccount.vue')
  },
  {
    path: '/transferencia',
    name: 'Transferencia',
    component: () => import('../views/Transfer.vue')
  },
  {
    path: '/historico',
    name: 'Historico',
    component: () => import('../views/History.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
