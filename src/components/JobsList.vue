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
    <v-card-text v-if="showDeleteButton"
                 style="height:0px; bottom: 6.5rem;"
                 class="fixed pin-b pin-l">
      <v-btn absolute ripple x-large
        dark fab color="red darken-2"
        @click="onDeleteJob">
        <v-icon>mdi-delete</v-icon>
      </v-btn>
    </v-card-text>
    <v-card-text style="height:0px; bottom: 6.5rem; left: 10rem;"
                 class="fixed pin-r">
      <v-btn absolute ripple x-large
        dark fab color="yellow darken-2"
        @click="onCreateUser">
        <v-icon>mdi-account</v-icon>
      </v-btn>
    </v-card-text>
    <v-card-text v-if="showAddButton"
                 style="height:0px; bottom: 6.5rem;"
                 class="fixed pin-b pin-r">
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
  components: {},
  props: {
    items: {
      type: Array,
      default: () => ([])
    },
    showAddButton: {
      type: Boolean,
      default: false
    },
    showDeleteButton: {
      type: Boolean,
      default: false
    }
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
  watch: {
    items: {
      handler: function() {
        this.jobs = this.items
      },
      immediate: true
    }
  },
  // computed: {
  //   deliveryTypeIcon() {
  //
  //     return
  //   }
  // },
  methods: {
    onJobClicked(job) {
      this.$router.push({name: 'job', params: { jobId: job.jobId }})
    },
    onDeleteJob() {
      this.$store.dispatch('deleteAllJob')
    },
    onCreateUser() {
      this.$store.dispatch('createUser', { name: 'Konstantin Steinmiller', phone: '123123123' })
    },
  }
};
</script>
