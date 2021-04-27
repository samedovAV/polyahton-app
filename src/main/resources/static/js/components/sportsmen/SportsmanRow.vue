<template>
    <v-card>
      <v-card-text primary-title>
        <i>({{ sportsman.id }})</i>
        {{ sportsman.firstName }}
      </v-card-text>
      <v-card-actions>
        <v-btn value="edit" @click="edit" small text rounded>Edit</v-btn>
        <v-btn icon @click="del" small>
          <v-icon>delete</v-icon>
        </v-btn>
      </v-card-actions>
      <participation-list
          :participations="sportsman.participations"
          :sportsman-id="sportsman.id"
      ></participation-list>
    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    import ParticipationList from '../participation/ParticipationList.vue'

    export default {
      components: {ParticipationList},
      props: [ 'sportsman', 'editSportsman' ],
        methods: {
          ...mapActions(['removeSportsmanAction']),
          edit() {
              this.editSportsman(this.sportsman)
          },
          del() {
              this.removeSportsmanAction(this.sportsman)
          }
    }
}
</script>

<style>

</style>