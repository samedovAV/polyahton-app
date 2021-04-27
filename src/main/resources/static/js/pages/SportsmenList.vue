<template>
  <v-container>
    <div>
      <sportsman-form :sportsmanAttr="sportsman" />
      <v-container class="grey lighten-5">
        <v-row
            v-for="sportsman in sortedSportsmen"
            :key="sportsman.id"
            no-gutters
        >
          <v-col>
            <v-card
                class="pa-2"
                outlined
                tile
            >
              <sportsman-row
                  :sportsman="sportsman"
                  :editSportsman="editSportsman"
              />
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </v-container>
</template>

<script>
    import { mapGetters } from 'vuex'
    import SportsmanRow from 'components/sportsmen/SportsmanRow.vue'
    import SportsmanForm from 'components/sportsmen/SportsmanForm.vue'

    export default {
        components: {
            SportsmanRow,
            SportsmanForm
        },
        data() {
            return {
                sportsman: null
            }
        },
        computed: mapGetters(['sortedSportsmen']),
        methods: {
            editSportsman(sportsman) {
            this.sportsman = sportsman
            }
        }
    }
</script>

<style>

</style>