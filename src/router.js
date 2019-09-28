import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Register from './views/Register.vue'
import Job from './views/Job.vue'
import openJobs from './views/openJobs.vue'
import usersJobs from './views/usersJobs.vue'
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
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/jobs',
      name: 'jobs',
      component: openJobs
    },
    {
      path: '/my-jobs',
      name: 'my-jobs',
      component: usersJobs
    },
    {
      path: '/job/:jobId',
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
