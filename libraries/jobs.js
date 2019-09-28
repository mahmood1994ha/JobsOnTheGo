import axios from 'axios'

const api = axios.create({
  // baseURL: 'https://jsonbox.io/box_958403defabca1aa19e6/',
  baseURL: 'http://10.4.134.253:8080/',
  timeout: 2000,
  headers: {
    'content-type': 'application/json'
  }
})

const mapJobData = function (data) {
  return {
    title: data.ltitle,
    jobId: data.jobID,
    consumerId: data.lConsumerID,
    channelId: data.lchannelID,
    producerId: data.lproducerID,
    description: data.ldescription,
    srcAdress: {
      lineOne: data.srcAddressLine,
      street: data.srcStreet,
      streetNumber: data.srcStreetNo,
      plz: data.srcZIP,
      town: data.srcCity,
      lat: data.lsrcLat,
      lon: data.lsrcLong
    },
    dstAdress: {
      lineOne: data.dstAddressLine,
      street: data.dstStreet,
      streetNumber: data.dstStreetNo,
      plz: data.dstZIP,
      town: data.dstCity,
      lat: data.ldstLat,
      lon: data.ldstLong
    },
    isJobActive: data.lisActive,
    isJobAssigned: data.lisAssigned,
    fee: data.ltokenCount
  }
}

const userId = 0

export default {
  fetchAllJobs: async payload => {
    const { data } = await api.get('getjoblist')
    return data.map(data => (mapJobData(data)))
  },
  fetchUsersJobs: async payload => {
    const { data } = await api.get(`jobs?q=producerId=${data.id}  `)
    return data
  },
  createJob: async data => {
    const params = {
      ...data,
    }
    const res = await api.get(`createjob`, { params, ...data})
    console.log('job created: ', res)
    return res
  },
  readJob: async payload => {
    const { data } = await api.get(`queryjob?job_id=${payload.jobId}`)
    console.log('data: ', data)
    return mapJobData(data)
  },
  createUser: async data => {
    const params = `usr_name=${data.name}&phone_no=${data.phone}`
    const res = await api.get(`createuser?${params}`, data)
    console.log('user created: ', res.data.usr_name)
    return res
  },
  readScooters: async data => {
    const params = `radius=1000&lat=${data.lat}&long=${data.lon}`
    const res = await api.get(`vehicles?${params}`, data)
    console.log('user created: ', res.data.usr_name)
    return res
  },
}
