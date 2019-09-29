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
          <div class="d-flex">
            <div class="flex-grow">
              <v-list-item-title>{{ `${job.title} - ${job.fee}€` }}</v-list-item-title>
              <v-list-item-subtitle class="mt-1">
                {{ `${job.srcAdress.lineOne}, ${job.srcAdress.street} ${job.srcAdress.streetNumber}, ${job.srcAdress.zip} ${job.srcAdress.town} -> ${job.dstAdress.lineOne}, ${job.dstAdress.street} ${job.dstAdress.streetNumber}, ${job.dstAdress.zip} ${job.dstAdress.town}` }}
              </v-list-item-subtitle>
              <v-list-item-subtitle class="mt-2">
                {{ job.description }}
              </v-list-item-subtitle>
            </div>
            <div class="d-flex align-center"><v-icon x-large>mdi-moped</v-icon></div>
          </div>
        </v-list-item-content>
      </v-list-item>
    </v-card>
    <!--<v-card-text v-if="showDeleteButton"
                 style="height:0px; bottom: 6.5rem;"
                 class="fixed pin-b pin-l">
      <v-btn absolute ripple x-large
        dark fab color="red darken-2"
        @click="onDeleteAllJob">
        <v-icon>mdi-delete</v-icon>
      </v-btn>
    </v-card-text>-->
    <!--<v-card-text style="height:0px; bottom: 6.5rem; left: 10rem;"
                 class="fixed pin-r">
      <v-btn absolute ripple x-large
        dark fab color="yellow darken-2"
        @click="onCreateUser">
        <v-icon>mdi-account</v-icon>
      </v-btn>
    </v-card-text>-->
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
    jobs: []
  }),
  watch: {
    items: {
      handler: function() {
        this.jobs = this.items
      },
      immediate: true
    }
  },
  methods: {
    onJobClicked(job) {
      this.$router.push({name: 'job', params: { jobId: job.jobId }})
    },
    onCreateUser() {
      this.$store.dispatch('createUser', { name: 'Konstantin Steinmiller', phone: '123123123' })
      this.$store.dispatch('readScooters', { lat: '51.50441060000001', lon: '7.526894099999999' })
    },
    async onDeleteAllJob() {
      await this.$store.dispatch('deleteAllJob')
    },
  }
};
</script>
