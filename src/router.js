import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Job from './views/Job.vue'
import openJobs from './views/openJobs.vue'
import myJobs from './views/myJobs.vue'
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
      component: openJobs
    },
    {
      path: '/my-jobs',
      name: 'my-jobs',
      component: myJobs
    },
    {
      path: '/job/:id',
      name: 'job',
      component: Job
    },
    {
      path: '/create-job',
      name: 'create-job',
      component: createJob
    }
  ]
})
