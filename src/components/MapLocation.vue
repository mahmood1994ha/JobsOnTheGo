<template>
  <div class="map-location">
    <div class="flex flex-wrap lg:flex-no-wrap pt-3">
      <div
        v-if="completeLocations.length"
        class="w-full md:w-auto lg:w-1/2 mx-auto text-center"
      >
        <div id="map" ref="gMap" class="w-full md:w-128 lg:w-full h-96"></div>
      </div>
      <div class="flex flex-wrap w-full lg:w-1/2 lg:ml-8 mt-6 lg:mt-0">
        <div
          v-for="(location, index) in locations"
          :key="index"
          :is-main-location="location.isMain"
          class="self-start w-full p-3 cursor-pointer d-flex"
          @click="onLocationClicked(index)"
        >
          <v-icon slot="icon" class="mr-2" :class="{ 'location-is-main text-green': location.isMain }">
            mdi-map-marker
          </v-icon>

          <div class="flex-grow">
            <div class="inline-block pb-2 mb-1">
              {{ location.title }}
            </div>

            <template v-if="location.location.addressLineOne">
              <div class="pb-2">
                {{ location.location.addressLineOne }}
              </div>
            </template>
            <template v-if="location.location.addressLineTwo">
              <div class="pb-2">
                {{ location.location.addressLineTwo }}
              </div>
            </template>
            <template v-if="location.location.zipcode || location.location.city">
              <div class="pb-2">
                {{ location.location.zipcode }} {{ location.location.city }}
              </div>
            </template>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import gmapsInit from '../helpers/google-maps'
const colors = require('../../colors.json')

export default {
  props: {
    locations: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      markers: [],
      map: null,
      bounds: null
    }
  },
  computed: {
    completeLocations() {
      return this.locations.filter(
        loc => loc.location && loc.location.lat && loc.location.lng
      )
    }
  },
  beforeDestroy() {
    // remove the google maps api object and the dom node so it doesn't get duplicated
    this.$refs['gMap'] && this.$refs['gMap'].remove()
    window.google = {}
  },
  mounted() {
    if (this.completeLocations.length) {
      gmapsInit()
        .then(() => this.initMap())
        .catch(e => {
          throw e
        })
    }
  },
  methods: {
    initMap() {
      this.map = new window.google.maps.Map(document.getElementById('map'), {
        zoomControl: true,
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: true
      })

      this.bounds = new window.google.maps.LatLngBounds()
      this.markers = this.completeLocations.map(loc => {
        const marker = new window.google.maps.Marker({
          position: { lat: loc.location.lat, lng: loc.location.lng },
          map: this.map,
          animation: window.google.maps.Animation.DROP,
          icon: this.getColoredIcon(loc.isMain)
        })

        // make markers clickable
        marker.addListener('click', this.zoomOntoMarker)

        // make markers fit into bounding box
        this.bounds.extend(marker.position)
        return marker
      })

      this.map.fitBounds(this.bounds)

      // add watcher to set zoom level, if only one location exists
      // we dont want it to max zoom onto it in this case
      const listener = window.google.maps.event.addListener(
        this.map,
        'idle',
        () => {
          if (this.map.getZoom() > 16) {
            this.map.setZoom(11)
          }
          window.google.maps.event.removeListener(listener)
        }
      )
    },
    setMarkerZoomBounds() {
      if (this.completeLocations.length) {
        this.vm.nextTick(() => {
          this.map.fitBounds(this.bounds)
          if (this.map.getZoom() > 16) {
            this.map.setZoom(11)
          }
        })
      }
    },
    zoomOntoMarker(marker) {
      if (this.completeLocations.length) {
        this.map.setZoom(13)
        this.map.setCenter(marker.latLng || marker.position)
      }
    },
    // create location_on icon from svg path to color them differently for main and normal location
    getColoredIcon(isMain) {
      return {
        path:
          'M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z',
        fillColor: isMain ? colors['teal'] : colors.black,
        strokeColor: isMain ? colors['teal'] : colors.black,
        fillOpacity: 1,
        anchor: new window.google.maps.Point(12, 24),
        scale: 1.5
      }
    },
    onLocationClicked(index) {
      this.zoomOntoMarker(this.markers[index])
    }
  }
}
</script>

<style lang="scss" scoped>
  .location-is-main {
    color: #38a89d;
  }
</style>
