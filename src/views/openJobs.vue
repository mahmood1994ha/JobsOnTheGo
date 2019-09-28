<template>
  <jobs-list :items="jobsList" show-add-button show-delete-button></jobs-list>
</template>

<script>
import JobsList from '../components/JobsList'

export default {
  components: { JobsList },

  data:() => ({
    // items: [
    //   {
    //     id: 1,
    //     title: 'Help me renovate ',
    //     fee: 25,
    //     source: 51.3,
    //     destination: 8.3,
    //     description: 'Help me renovate Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.!',
    //   },
    //   {
    //     id: 2,
    //     title: 'Help me renovate ',
    //     fee: 3,
    //     source: 51.3,
    //     destination: 8.3,
    //     description: 'Bring me FOOOD! Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.',
    //   }]
  }),
  computed: {
    jobsList() {
      console.log('allJobs: ', this.$store.state.allJobs, this.$store.state)
      return this.$store.state.allJobs
    },
  },
  created() {
    this.fetchJobs()
  },
  methods: {
    async fetchJobs() {
      await this.$store.dispatch('fetchAllJobs')
    }
  }
};
</script>
