import axios from 'axios'

const api = axios.create({
  baseURL: 'https://jsonbox.io/box_958403defabca1aa19e6/',
  timeout: 2000,
  headers: {
    'content-type': 'application/json'
  }
})
const mapJobItem = function(item) {
  return {
    jobId: item._id,
    ...item
  }
}
const userId = 'Konstantin Steinmiller'

export default {
  fetchAllJobs: async payload => {
    const { data } = await api.get('jobs')
    return data.map(data => (mapJobItem(data)))
  },
  fetchUsersJobs: async payload => {
    const { data } = await api.get(`jobs?q=fee:<=25`)
    return data
  },
  createJob: async payload => {
    const res = await api.post(`jobs`, payload)
    console.log('job created: ', res)
    return res
  },
  readJob: async payload => {
    const { data } = await api.get(`jobs/${payload.jobId}`)
    console.log('readJob: ', data)
    return mapJobItem(data)
  },
  deleteAllJob: async data => {
    const res = await api.delete(`jobs?q=fee:<=25`)
    console.log('deleted all jobs: ', res)
    return res
  },
  createUser: async payload => {
    const { data } = await api.post(`user`, payload)
    console.log('user created: ', data)
    return data
  }
}
