import Vue from 'vue'
import Vuex from 'vuex'
import jobs from './store/jobs'

Vue.use(Vuex)

export default new Vuex.Store({
  namespaced: true,
  state: {},
  mutations: {},
  actions: {},
  modules: {
    jobs
  }
})
