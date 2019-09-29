import axios from 'axios'

export const getAPIGeolocation = function() {
  return axios
    .post(
      'https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDsmLGKrg3lLEZZyilKNQAPc6iJPzMBXf0'
    )
    .then(res => Promise.resolve(res))
    .catch(function(err) {
      console.log(
        `API Geolocation error! \\n\\n${JSON.stringify(err, undefined, 2)}`
      )
    })
}
