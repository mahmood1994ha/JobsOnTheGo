import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Jobs from './views/Jobs.vue'
import Job from './views/Job.vue'
import createJob from './views/createJob.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/jobs',
      name: 'jobs',
      component: Jobs
    },
    {
      path: '/job/:id',
      name: 'job',
      component: Job
    },
    {
      path: '/create-job/:id',
      name: 'create-job',
      component: createJob
    }
  ]
})
