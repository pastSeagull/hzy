import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import VueCookies from 'vue-cookies'
import axios from 'axios'
//
// // 让ajax携带cookie
axios.defaults.withCredentials=true;

// // 使用 vue cookie
Vue.use(VueCookies)
Vue.config.productionTip = false

Vue.prototype.SERVER_API_URL = "http://localhost:9091/api";

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
