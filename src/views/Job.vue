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

      <map-location class="mt-4" :locations="locations"></map-location>
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
    }
  },
  computed: {
    job() {
      return this.$store.state.currentJob
    },
    locations() {
      return (this.job && [
        {
          title: 'From',
          location: {
            lat: this.job.srcAdress.lat,
            lng: this.job.srcAdress.lon,
            addressLineOne: `${this.job.srcAdress.lineOne}, ${this.job.srcAdress.street} ${this.job.srcAdress.streetNumber}`,
            zipcode: this.job.srcAdress.zip,
            city: this.job.srcAdress.town
          },
          isMain: false
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
          isMain: false
        }
      ]) || []
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
    requestGeoLocation() {
      if (navigator.geolocation) {
        var startPos;
        var geoSuccess = function(position) {
          startPos = position;
          document.getElementById('startLat').innerHTML = startPos.coords.latitude;
          document.getElementById('startLon').innerHTML = startPos.coords.longitude;
        };
        navigator.geolocation.getCurrentPosition(geoSuccess);
      } else {
        alert('Geolocation is not supported for this Browser/OS.');
      }
    }
  }
};
</script>
