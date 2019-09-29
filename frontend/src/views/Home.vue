<template>
  <v-container fluid>
    <div class="title">Welcome to DeliverOnTheGo!</div>
    <div>We help people get their stuff done and create jobs.</div>

    <v-card class="mt-6" @click="$router.push({name: 'jobs'})">
      <v-container class="" style="max-width: 80% ">
        <div class="min-h-32 text-center">
          <v-icon style="font-size: 7rem">mdi-tools</v-icon>
        </div>
        <div class="title text-center">
          All jobs
        </div>
      </v-container>
    </v-card>
    <v-card class="mt-6" @click="$router.push({name: 'create-job'})">
      <v-container class="" style="max-width: 80% ">
        <div class="min-h-32 text-center">
          <v-icon style="font-size: 7rem">mdi-plus</v-icon>
        </div>
        <div class="title text-center">Create a job</div>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>

export default {

};
</script>
