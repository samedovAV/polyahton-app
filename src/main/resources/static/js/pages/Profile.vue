<template>
  <div>
    <v-card
        class="d-flex justify-space-around mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
    >
      <v-card
          v-for="n in 1"
          :key="n"
          class="pa-2"
          outlined
          tile
      >
        <div class="title mb-3">User profile</div>
        <div>
          <v-container fluid>
            <v-row dense>
              <v-col
                  v-for="n in 1"
                  :key="n"
              >
                <v-card
                    class="d-flex justify-space-between mb-6"
                    :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
                    flat
                    tile
                >
                  <v-flex>
                    <v-img :src="profile.userpic"></v-img>
                  </v-flex>
                  <v-container class="pt-1">
                    <v-flex>{{ profile.name }}</v-flex>
                    <v-flex>{{ profile.locale }}</v-flex>
                    <v-flex>{{ profile.gender }}</v-flex>
                    <v-flex>{{ profile.email }}</v-flex>
                    <v-flex>{{ profile.lastVisit }}</v-flex>
                  </v-container>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </div>
      </v-card>
    </v-card>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'Profile',
  computed: mapState([ 'profile' ])
}
</script>

<style scoped>
  img {
    max-width: 100%;
    height: auto;
  }
</style>