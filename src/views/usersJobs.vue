<template>
  <jobs-list :items="jobsList" show-add-button show-delete-button></jobs-list>
</template>

<script>
import JobsList from '../components/JobsList'

export default {
  components: { JobsList },
  computed: {
    jobsList() {
      console.log('myJobs: ', this.$store.state.usersJobs)
      return this.$store.state.usersJobs
    },
  },
  created() {
    this.fetchJobs()
  },
  methods: {
    async fetchJobs() {
      await this.$store.dispatch('fetchUsersJobs')
    }
  }
};
</script>
