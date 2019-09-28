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
      <div class="py-2">{{ `${job.title} - ${job.fee}€` }}</div>
      <div v-if="job.srcAdress" class="pt-2">{{ `From: ${job.srcAdress.lat}, ${job.srcAdress.lon}` }}</div>
      <div v-if="job.dstAdress"  class="pb-2">{{ `To: ${job.dstAdress.lat}, ${job.dstAdress.lon}` }}</div>
      <div>{{ job.description }}</div>
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

export default {
  computed: {
    job() {
      return this.$store.state.currentJob
    },
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
      const notification = { message: `Successfully created a user`, type: 'success' }
      await this.$store.dispatch('addNotification', notification)
      this.$router.push({name: 'jobs'})
    },
  }
};
</script>
