<template>
  <v-container fluid>
    <v-card
      class="mx-auto p-4"
      max-width="400"
      tile
    >
      <v-row justify="space-around">
        <v-avatar color="indigo circle" style="height: 6rem; width: 6rem;">
          <v-icon style="font-size: 4rem" dark>mdi-account-circle</v-icon>
        </v-avatar>
      </v-row>
      <div class="py-2 title">{{ `${job.title} - ${job.fee}€` }}</div>
      <div v-if="job.srcAdress && job.dstAdress" class="pt-2 mb-4">
        <adress-line :src-adress="job.srcAdress" :dst-adress="job.dstAdress"/>
      </div>
      <div>{{ job.description }}</div>

      <div class="d-flex justify-center">
        <v-btn class="mt-4" color="primary" @click="requestGeoLocation">Request my position</v-btn>
      </div>
      <map-location :key="mapInstanceKey" class="mt-4" :locations="locations"></map-location>
    </v-card>
    <div class="d-flex justify-end mt-6">
      <v-btn large color="error" class="mr-4" @click="onBack">
        <v-icon class="mr-2">mdi-arrow-left</v-icon>Back
      </v-btn>
      <v-btn large color="success" class="" @click="onAcceptJob">
        <v-icon class="mr-2">mdi-check</v-icon>Accept Job
      </v-btn>
    </div>
  </v-container>
</template>

<script>
import AdressLine from '../components/AdressLine'
import MapLocation from '../components/MapLocation'
import { getAPIGeolocation } from '../helpers/geolocation'

export default {
  components: { AdressLine, MapLocation },
  data() {
    return {
      // locations: [
      //   {
      //     location: {
      //       lat: 48.1447,
      //       lng: 11.559600000000046,
      //       addressLineOne: '',
      //       zipcode: '80992',
      //       city: 'Munich'
      //     },
      //     isMain: false
      //   },
      //   {
      //     location: {
      //       lat: 48.1287,
      //       lng: 11.65039999999999,
      //       addressLineOne: 'Wasen',
      //       zipcode: '80992',
      //       city: 'Munich'
      //     },
      //     isMain: false
      //   }/* ,
      //   {
      //     location: {
      //       lat: 48.1735835,
      //       lng: 11.5323446,
      //       addressLineOne: 'Agnes-Pockels-Bogen 1',
      //       zipcode: '80992',
      //       city: 'Munich'
      //     },
      //     isMain: false
      //   },
      //   {
      //     location: {
      //       lng: 10.5323446,
      //       addressLineOne: 'Agnes-Pockels-Bogen 1',
      //       zipcode: '80992',
      //       city: 'Munich'
      //     },
      //     isMain: false
      //   }*/
      // ]
      usersGeolocation: null,
      mapInstanceKey: 0
    }
  },
  computed: {
    job() {
      return this.$store.state.currentJob
    },
    locations() {
      const userPos = this.usersGeolocation
        ? this.usersGeolocation
        : null

      const locations = (this.job && [
        {
          title: 'From',
          location: {
            lat: this.job.srcAdress.lat,
            lng: this.job.srcAdress.lon,
            addressLineOne: `${this.job.srcAdress.lineOne}, ${this.job.srcAdress.street} ${this.job.srcAdress.streetNumber}`,
            zipcode: this.job.srcAdress.zip,
            city: this.job.srcAdress.town
          },
          isMain: false,
          isRouteWaypoint: true
        },
        {
          title: 'To',
          location: {
            lat: this.job.dstAdress.lat,
            lng: this.job.dstAdress.lon,
            addressLineOne: `${this.job.dstAdress.lineOne}, ${this.job.srcAdress.street} ${this.job.srcAdress.streetNumber}`,
            zipcode: this.job.dstAdress.zip,
            city: this.job.dstAdress.town
          },
          isMain: false,
          isRouteWaypoint: true
        }
      ]) || []

      userPos && locations.push(userPos)

      return locations
    }
  },
  created() {
    this.fetchJob()
  },
  methods: {
    async fetchJob() {
      await this.$store.dispatch('readJob', { jobId: this.$route.params.jobId })
    },
    onBack() {
      this.$router.push({name: 'jobs'})
    },
    async onAcceptJob() {
      const notification = { message: `Successfully accepted the job`, type: 'success' }
      await this.$store.dispatch('addNotification', notification)

      await this.$store.dispatch('fetchAllJobs')
      this.$router.push({name: 'jobs'})
    },
    async requestGeoLocation() {
      if (navigator.geolocation) {
        const { data } = await getAPIGeolocation()
        this.usersGeolocation = {
          title: 'Your position',
          location: {
            lat: data.location.lat,
            lng: data.location.lng,
            addressLineOne: '',
            zipcode: '',
            city: ''
          },
          isMain: true
        }
        this.mapInstanceKey++

        console.log('geolocationResult: ', data)
      } else {
        this.$store.dispatch('addNotification', { message: 'Geolocation is not supported for this Browser/OS.', type: 'warning' });
      }
    }
  }
};
</script>
