<template>
  <v-container fluid>
    <div class="title">Welcome to DeliverOnTheGo!</div>
    <div>We help people get their stuff done and create jobs.</div>

    <div class="d-flex justify-center mt-6">
      <v-btn large class="title mt-4 mr-4"
             color="primary"
             @click="$router.push({name: 'jobs'})">
        <v-icon class="mr-2">mdi-tools</v-icon>
        <span>All jobs</span>
      </v-btn>
      <v-btn large class="title mt-4"
             color="primary"
             @click="$router.push({name: 'create-job'})">
        <v-icon class="mr-2">mdi-plus</v-icon>
        <span>Create a job</span>
      </v-btn>
    </div>
  </v-container>
</template>

<script>

export default {
  components: { },
};
</script>
