<template>
  <v-container fluid>
    <v-card
        class="mx-auto"
        max-width="400"
        tile
    >
      <!--                 :to="{ name:'job', params: { id: job.id } }"-->
      <v-list-item three-line
                   v-for="(job, index) in jobs"
                   :key="index"
                   @click="onJobClicked(job)">
        <v-list-item-content>
          <v-list-item-title>{{ `${job.title} - ${job.fee}€` }}</v-list-item-title>
          <v-list-item-subtitle class="">
            {{ job.source }} -> {{ job.destination }}
          </v-list-item-subtitle>
          <v-list-item-subtitle>
            {{ job.description }}
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
    </v-card>
    <v-card-text style="height:0px; bottom: 6.5rem;" class="fixed pin-b pin-r">
      <v-btn absolute ripple x-large
        dark fab right color="blue darken-2"
        @click="$router.push({name: 'create-job'})">
        <v-icon>mdi-plus</v-icon>
      </v-btn>
    </v-card-text>
  </v-container>
</template>

<script>

export default {
  components: {
  },

  data:() => ({
    jobs: [
      {
        id: 1,
        title: 'Help me renovate ',
        fee: 25,
        source: 51.3,
        destination: 8.3,
        description: 'Help me renovate Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.!',
      },
      {
        id: 2,
        title: 'Help me renovate ',
        fee: 3,
        source: 51.3,
        destination: 8.3,
        description: 'Bring me FOOOD! Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.',
      }]
  }),
  methods: {
    onJobClicked(job) {
      this.$router.push({name: 'job', params: { id: job.id }})
    },
  }
};
</script>
