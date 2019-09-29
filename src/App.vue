<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app clipped>
      <v-list dense>
        <v-list-item>
          <v-list-item-action>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="$router.push({name: 'home'})">Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-action>
            <v-icon>mdi-tools</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="$router.push({name: 'jobs'})">Jobs</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <!--<v-list-item>
          <v-list-item-action>
            <v-icon>mdi-account</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="$router.push({name: 'my-jobs'})"
            >My Jobs</v-list-item-title>
          </v-list-item-content>
        </v-list-item>-->
        <v-list-item>
          <v-list-item-action>
            <v-icon>mdi-playlist-plus</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="$router.push({name: 'create-job'})"
            >Create a Job</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-action>
            <v-icon>mdi-account-plus</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="$router.push({name: 'register'})"
            >Register</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      clipped-left
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>DeliverOnTheGo
        <img style="height: 1.5rem; margin-left: 1rem; margin-bottom: -.25rem" src="../public/img/logo.png">
      </v-toolbar-title>
    </v-app-bar>

    <v-content>

      <router-view/>
      <!--<v-container
          class="fill-height"
          fluid
      >
        <v-row
          align="center"
          justify="center"
      >
        <v-col class="shrink">
          <v-tooltip right>
            <template v-slot:activator="{ on }">
              <v-btn
                  :href="source"
                  icon
                  large
                  target="_blank"
                  v-on="on"
              >
                <v-icon large>mdi-code-tags</v-icon>
              </v-btn>
            </template>
            <span>Source</span>
          </v-tooltip>
          <v-tooltip right>
            <template v-slot:activator="{ on }">
              <v-btn
                  icon
                  large
                  href="https://codepen.io/johnjleider/pen/bXNzZL"
                  target="_blank"
                  v-on="on"
              >
                <v-icon large>mdi-codepen</v-icon>
              </v-btn>
            </template>
            <span>Codepen</span>
          </v-tooltip>
        </v-col>
      </v-row>
      </v-container>-->
    </v-content>

    <v-snackbar top v-model="notification.message" :color="notification.type"
                v-for="(notification, index) in notifications" :key="index">
      {{ notification.message }}
      <v-btn color="white" text
             @click="removeNotification(index)"
      >
        <v-icon>mdi-close</v-icon>
      </v-btn>
    </v-snackbar>

    <v-footer app>
      <span>&copy; 2019 by DeliverOnTheGo</span>
    </v-footer>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  props: {
    source: String,
  },
  data: () => ({
    drawer: null,
  }),

  computed: {
    notifications() {
      return this.$store.state.notifications
    }
  },
  created () {
    this.$vuetify.theme.dark = true
  },
  methods: {
    removeNotification(index) {
      this.$store.dispatch('removeNotification', index)
    }
  }
};
</script>
