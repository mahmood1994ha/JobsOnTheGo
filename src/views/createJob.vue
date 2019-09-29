<template>
  <v-container fluid>
    <v-card class="mx-auto p-4" max-width="400" tile>
      <v-form
        ref="form"
        v-model="valid"
        :lazy-validation="true"
      >
        <v-text-field v-model="title"
                      label="Title"
                      required/>
        <v-textarea
            outlined
            name="input-7-4"
            label="Description"
            v-model="description"
        ></v-textarea>

        <v-divider></v-divider>
        <adress class="src-adress" v-model="srcAdress"></adress>
        <v-divider></v-divider>
        <adress class="dest-adress" v-model="dstAdress"></adress>
        <v-divider></v-divider>

        <v-text-field v-model="phone"
                      class="pt-6"
                      label="Phone"
                      number
                      required/>
        <v-row>
          <v-col>
            <v-select
              v-model="jobType"
              :items="jobTypes"
              :rules="[v => !!v || 'Item is required']"
              label="Job type"
              required></v-select>
          </v-col>
          <v-col>
            <v-text-field v-model="fee"
                          label="Fee"
                          number
                          required/>
          </v-col>
        </v-row>

        <div class="d-flex justify-end">
          <v-btn color="error" class="mr-4" @click="onCancel">
            Cancel
          </v-btn>
          <v-btn color="success" @click="onCreateJob">
            Create Job
          </v-btn>
        </div>
      </v-form>
    </v-card>
  </v-container>
</template>

<script>
  import Adress from '@/components/Adress'

export default {
  components: { Adress },
  data:() => ({
    valid: true,
    title: 'Help me renovate!',
    jobType: 'delivery',
    fee: 25,
    phone: '017612345678',
    srcAdress: {
      lineOne: 'Backwerk',
      street: 'Am Kai',
      streetNumber: 16,
      zip: 44263,
      town: 'Dortmund',
      lat: 4,
      lon: 56
    },
    dstAdress: {
      lineOne: 'Adesso',
      street: 'Adessoplatz',
      streetNumber: 1,
      zip: 44269,
      town: 'Dortmund',
      lat: 6,
      lon: 52
    },
    description: 'I\'m renovating this weekend and need some helping hands for basic work like: moving stuff, painting walls and build up furniture.',
    jobTypes: [
      { label: 'delivery', value: 'delivery'},
      { label: 'relocation help', value: 'relocation-help' },
      { label: 'groceries', value: 'groceries' }
    ],
  }),
  computed: {
    userId() {
      return this.$store.state.userId
    }
  },
  methods: {
    onJobClicked(job) {
      this.$router.push({name: 'job', params: { id: job.id }})
    },
    onCancel() {
      this.$router.push({ name: 'jobs' })
    },
    async onCreateJob() {
      await this.$store.dispatch('createJob', {
        title: this.title,
        tokencount: this.fee,
        src_street: this.srcAdress.street,
        src_no: this.srcAdress.streetNumber,
        src_addr_line: this.srcAdress.lineOne,
        src_zip: this.srcAdress.zip,
        src_city: this.srcAdress.town,
        dst_street: this.dstAdress.street,
        dst_no: this.dstAdress.streetNumber,
        dst_addr_line: this.dstAdress.lineOne,
        dst_zip: this.dstAdress.zip,
        dst_city: this.dstAdress.town,
        description: this.description,
        job_type: this.jobType,
        tokenSet: true,
        prod_id: 0,
        cons_id: this.userId || 0,
      }
      /*{
        title: this.title,
        fee: this.fee,
        phone: this.phone,
        srcAdress: this.srcAdress,
        destAdress: this.destAdress,
        jobType: this.jobType,
        description: 'Help me renovate Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.!',
      }*/)
      const notification = { message: `Successfully created a job with title: "${this.title}"`, type: 'success' }
      await this.$store.dispatch('addNotification', notification)

      await this.$store.dispatch('fetchAllJobs')
      this.$router.push({ name: 'jobs' })
    },
  }
};
</script>
