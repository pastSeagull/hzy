import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/Register',
        name: 'Register',
        component: Register
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
        if (to.meta.requireAuth) {
            let date = new Date();
            if (store.state.user.username && store.state.user.power && store.state.user.expirationTime >= date.getTime()) {
                next();
            } else {
                next({
                    path: 'login',
                    query: {redirect: to.fullPath}
                })
            }
        } else {
            next()
        }
    }
)
export default router
