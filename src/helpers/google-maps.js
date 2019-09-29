export default function init() {
  const API_KEY = process.env.VUE_APP_GOOGLE_MAPS_API_KEY
  console.log('API_KEY: ', API_KEY)
  const CALLBACK_NAME = 'gmapsCallback'

  let resolveInitPromise
  let rejectInitPromise
  const initPromise = new Promise((resolve, reject) => {
    resolveInitPromise = resolve
    rejectInitPromise = reject
  })

  window[CALLBACK_NAME] = () => resolveInitPromise(window.google)

  const script = document.createElement('script')
  script.async = true
  script.defer = true
  script.src = `https://maps.googleapis.com/maps/api/js?key=${API_KEY}&callback=${CALLBACK_NAME}`
  script.onerror = rejectInitPromise
  document.querySelector('head').appendChild(script)

  return initPromise
}
