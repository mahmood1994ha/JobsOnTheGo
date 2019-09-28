import Vue from 'vue'
import Vuex from 'vuex'
import api from '../libraries/jobs'
// import api from '../libraries/jsonboxjobs'

Vue.use(Vuex)

export default new Vuex.Store({
  namespaced: true,
  state: {
    allJobs: [],
    usersJobs: [],
    currentJob: {},
    notifications: [],
    deliveryTypes: []
  },
  mutations: {
    setAllJobs: (state, data) => {
      state.allJobs = data
    },
    setUsersJobs: (state, data) => {
      state.usersJobs = data
    },
    setCurrentJob: (state, data) => {
      state.currentJob = data
    },
    addNotification: (state, data) => {
      state.notifications.push(data)
    },
    removeNotification: (state, data) => {
      state.notifications.splice(data, 1)
    }
  },
  actions: {
    async fetchAllJobs({ commit }, data) {
      const jobs = await api.fetchAllJobs(data)
      commit('setAllJobs', jobs)
      return jobs
    },
    async fetchUsersJobs({ commit }, data) {
      const jobs = await api.fetchUsersJobs(data)
      commit('setUsersJobs', jobs)
      return jobs
    },
    async createJob({ commit }, data) {
      return await api.createJob(data)
    },
    async readJob({ commit }, data) {
      const job = await api.readJob(data)
      commit('setCurrentJob', job)
      return job
    },
    async deleteAllJob({ commit }, data) {
      return await api.deleteAllJob(data)
    },
    async createUser({ commit }, data) {
      return await api.createUser(data)
    },
    async addNotification({ commit }, data) {
      commit('addNotification', data)
    },
    async removeNotification({ commit }, data) {
      commit('removeNotification', data)
    },
    async readScooters({ commit }, data) {
      return await api.readScooters(data)
    }
  }
})
