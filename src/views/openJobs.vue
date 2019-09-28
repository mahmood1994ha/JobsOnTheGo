<template>
  <jobs-list :items="items"></jobs-list>
</template>

<script>
import JobsList from '../components/JobsList'

export default {
  components: { JobsList },

  data:() => ({
    items: [
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
  created() {
    this.$store.dispatch('jobs/')
  },
  methods: {

  }
};
</script>
