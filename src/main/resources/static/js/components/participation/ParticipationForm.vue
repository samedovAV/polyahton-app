<template>
  <v-row>
    <v-text-field
        label="Regular"
        placeholder="Placeholder"
        v-model="name"
        append-icon="add"
        @click:append="save"
        @keyup.enter="save"
    />
  </v-row>
</template>

<script>

  import { mapActions } from 'vuex'

  export default {
    name: 'ParticipationForm',
    props: ['sportsmanId'],
    data() {
      return {
        name: ''
      }
    },
    methods: {
      ...mapActions(['addParticipationAction']),
      async save() {
        await this.addParticipationAction({
          name: this.name,
          sportsman: {
            id: this.sportsmanId
          }
        })
        this.name = ''
      }
    }
  }
</script>

<style scoped>

</style>