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
        <v-text-field v-model="adress.lineOne"
                      class="pt-6"
                      label="Adress line"
                      required/>
        <v-row>
          <v-col>
            <v-text-field v-model="adress.street"
                          label="Street"
                          required/>
          </v-col>
          <v-col>
            <v-text-field v-model="adress.streetNumber"
                          label="Street number"
                          number
                          required/>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field v-model="adress.plz"
                          label="Plz"
                          number
                          required/>
          </v-col><v-col>

          <v-text-field v-model="adress.town"
                        label="Town"
                        required/>
        </v-col>
        </v-row>
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

        <!--<v-checkbox
          v-model="checkbox"
          :rules="[v => !!v || 'You must agree to continue!']"
          label="Do you agree?"
          required
        ></v-checkbox>-->

        <div class="d-flex justify-end">
          <v-btn color="error" class="mr-4" @click="$router.push({ name: 'jobs' })">
            Cancel
          </v-btn>
          <v-btn color="success" @click="createJob">
            Create Job
          </v-btn>
        </div>
      </v-form>
    </v-card>
  </v-container>
</template>

<script>

export default {
  components: {
  },

  data:() => ({
    valid: true,
    title: 'Help me renovate!',
    jobType: 'delivery',
    fee: 25,
    adress: {
      lineOne: 'Backwerk',
      street: 'Am Kai',
      streetNumber: 16,
      plz: 44263,
      town: 'Dortmund'
    },
    phone: '017612345678',
    source: 51.3,
    destination: 8.3,
    srcAdress: 'Citybäcker, Am Kai 16, 44263 Dortmund',
    destAdress: 'Adesso, Adessoplatz 1, 44269 Dortmund',
    description: 'I\'m renovating this weekend and need some helping hands for basic work like: moving stuff, painting walls and build up furniture.',
    jobTypes: ['delivery', 'relocation help', 'groceries'],
  }),
  methods: {
    onJobClicked(job) {
      console.log('onJobClicked: ', job)
      this.$router.push({name: 'job', params: { id: job.id }})
    },
  }
};
</script>
