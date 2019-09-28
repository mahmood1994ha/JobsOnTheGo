<template>
  <v-container fluid>
    <v-card
      class="mx-auto p-4"
      max-width="400"
      tile
    >
      <div class="py-2">{{ `${job.title} - ${job.fee}€` }}</div>
      <div class="pt-2">{{ `From: ${job.srcAdress}` }}</div>
      <div class="pb-2">{{ `To: ${job.destAdress}` }}</div>
      <div>{{ job.description }}</div>
    </v-card>
  </v-container>
</template>

<script>

export default {
  components: {
  },

  data:() => ({
    job: {
      id: 1,
      title: 'Help me renovate ',
      fee: 25,
      source: 51.3,
      destination: 8.3,
      srcAdress: 'Citybäcker, Am Kai 16, 44263 Dortmund',
      destAdress: 'Adesso, Adessoplatz 1, 44269 Dortmund',
      description: 'Help me renovate Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.!',
    }
  }),
  methods: {
    onJobClicked(job) {
      console.log('onJobClicked: ', job)
      this.$router.push({name: 'job', params: { id: job.id }})
    },
  }
};
</script>
