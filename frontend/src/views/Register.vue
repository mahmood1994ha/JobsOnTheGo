<template>
  <v-container fluid>
    <v-content>
      <img style="height: 30vw; margin-left: 32vw; margin-bottom: 1rem; margin-top: -3rem" src="../../public/img/logo.png">
      <v-card >
        <v-toolbar color="blue" dark>
          <v-icon class="mr-4">mdi-account-plus</v-icon>
          <v-toolbar-title>Sign up</v-toolbar-title>
        </v-toolbar>

        <v-container>

          <v-text-field v-model="name"
                        label="Name"
                        required/>
          <v-text-field v-model="phone"
                        label="Phone"
                        required/>
          <v-text-field
              v-model="password"
              :append-icon="showFirstIcon ? 'mdi-visibility' : 'mdi-visibility_off'"
              :rules="[rules.required, rules.min]"
              :type="showFirstIcon ? 'text' : 'password'"
              name="input-10-1"
              label="Password"
              hint="At least 8 characters"
              counter
              @click:append="showFirstIcon = !showFirstIcon"
          ></v-text-field>
          <v-text-field
              v-model="passwordRepeat"
              :append-icon="showSecondIcon ? 'mdi-visibility' : 'mdi-visibility_off'"
              :rules="[rules.required, rules.min]"
              :type="showSecondIcon ? 'text' : 'password'"
              name="input-10-1"
              label="Repeat password"
              hint="At least 8 characters. Must match with the password field!"
              counter
              @click:append="showSecondIcon = !showSecondIcon"
          ></v-text-field>
          <div class="d-flex justify-end mt-4">
            <v-btn color="primary" @click="register">
              <v-icon>mdi-check</v-icon>
              Register
            </v-btn>
          </div>
        </v-container>
      </v-card>
    </v-content>
  </v-container>
</template>

<script>

export default {
  data:() => ({
    showFirstIcon: false,
    showSecondIcon: false,
    password: '12345678',
    passwordRepeat: '12345678',
    name: 'Konstantin',
    phone: '017612345678',
    rules: {
      required: value => !!value || 'Required.',
      min: v => v.length >= 8 || 'Min 8 characters',
    },
  }),
  methods: {
    async register() {
      if (this.password === this.passwordRepeat && this.password.length >= 8) {
        await this.$store.dispatch('createUser', {
          name: this.name,
          phone: this.phone,
          password: this.password
        })
        this.$router.push({ name: 'home' })
      }
    }
  }
};
</script>
