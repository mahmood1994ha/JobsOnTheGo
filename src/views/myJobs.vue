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
        id: 2,
        title: 'Help me renovate ',
        fee: 3,
        source: 51.3,
        destination: 8.3,
        description: 'Bring me FOOOOOOOOOOOOOOOOOOOOD!',
      }]
  }),
  methods: {

  }
};
</script>
