import axios from 'axios'

const api = axios.create({
  // baseURL: 'https://jsonbox.io/box_958403defabca1aa19e6/',
  baseURL: 'http://10.4.134.253:8080/',
  timeout: 2000,
  headers: {
    'content-type': 'application/json'
  }
})

const userId = 'Konstantin Steinmiller'

export default {
  fetchAllJobs: async payload => {
    const { data } = await api.get('getjoblist')
    return data.map(data => ({
      jobId: data.jobID,
      consumerId: data.lConsumerID,
      channelId: data.lchannelID,
      producerId: data.lproducerID,
      description: data.ldescription,
      srcAdress: { lat: data.lsrcLat, lon: data.lsrcLong},
      destAdress: { lat: data.ldstLat, lon: data.ldstLong},
      isJobActive: data.lisActive,
      isJobAssigned: data.lisAssigned,
      fee: data.ltokenCount
    }))
  },
  fetchUsersJobs: async payload => {
    const { data } = await api.get(`jobs?q=producerId=${data.id}  `)
    return data
  },
  createJob: async data => {
    const params = `title=${data.title}&src_lat=8.4&src_long=52&dst_lat=7.3&dst_long=51.3&description=${data.description}&tokenSet=true&tokencount=25&prod_id=${userId}&cons_id=${userId}`
    const res = await api.get(`createjob?${params}`, data)
    console.log('job created: ', res)
    return res
  },
  readJob: async payload => {
    const { data } = await api.get(`queryjob?job_id=${payload.jobId}`)
    console.log('data: ', data)
    return {
      jobId: data.jobID,
      consumerId: data.lConsumerID,
      channelId: data.lchannelID,
      producerId: data.lproducerID,
      description: data.ldescription,
      srcAdress: { lat: data.lsrcLat, lon: data.lsrcLong},
      destAdress: { lat: data.ldstLat, lon: data.ldstLong},
      isJobActive: data.lisActive,
      isJobAssigned: data.lisAssigned,
      fee: data.ltokenCount
    }
  },
  deleteAllJob: async data => {
    const res = await api.delete(`jobs?q=fee:<=25`)
    console.log('deleted all jobs: ', res, data)
    return res
  },
  createUser: async data => {
    const params = `usr_name=${data.name}&phone_no=${data.phone}`
    const res = await api.get(`createuser?${params}`, data)
    console.log('user created: ', res.data.usr_name)
    return res
  },
}
