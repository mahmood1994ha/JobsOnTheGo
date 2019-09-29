<template>
  <div class="adress">
    <v-text-field v-model="value.lineOne"
                  class="pt-6"
                  label="Adress line"
                  required/>
    <v-row>
      <v-col>
        <v-text-field v-model="value.street"
                      label="Street"
                      required/>
      </v-col>
      <v-col>
        <v-text-field v-model="value.streetNumber"
                      label="Street number"
                      number
                      required/>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-text-field v-model="value.zip"
                      label="Plz"
                      number
                      required/>
      </v-col><v-col>

      <v-text-field v-model="value.town"
                    label="Town"
                    required/>
    </v-col>
    </v-row>
  </div>
</template>

<script>
  export default {
    name: 'adress',
    props: {
      value: {
        type: Object,
        default: () => ({})
      }
    },
    watch: {
      value: {
        handler: function(n) {
          this.$emit('input', n)
        },
        deep: true
      }
    }
  };
</script>

<style scoped>

</style>