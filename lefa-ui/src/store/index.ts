import { createStore } from 'vuex'
import { storages } from './storage'
import { getRouter } from '../utils/api'
import { routes } from '../router/index'

const defaultState = {
  user: [],
  token: storages.getLocalStorageName || '',
  router: []
}

export default createStore({
  state() {
    return defaultState
  },
  mutations: {
    login(state: typeof defaultState, token) {
      state.token = token
      storages.setLocalStorageName = token
    },
    userInfo(state: typeof defaultState, user) {
      // 直接修改？
      // const newState = JSON.parse(JSON.stringify(state))
      state.user = user.data
    },
    // 合并router
    SET_ROUTES(state: typeof defaultState, routes) {
      state.router = routes.concat(routes)
    }
  },
  actions: {
    GenerateRoutes({ commit }) {
      getRouter().then((res) => {
        console.log(res)
        commit('SET_ROUTES', res)
      })
    }
  },
  getters: {}
})
