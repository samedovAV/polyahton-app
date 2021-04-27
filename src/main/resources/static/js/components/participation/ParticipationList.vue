<template>
  <v-list three-line>
    <v-subheader>
      Participations
    </v-subheader>
    <template
        v-for="(item, index) in participations"
    >
      <v-divider
          v-if="index > 0"
          :key="index"
      ></v-divider>

      <participation-item
          :participation="item"
          :key="'item' + index"
      ></participation-item>
    </template>

    <participation-form :sportsman-id="sportsmanId"></participation-form>
  </v-list>
</template>

<script>
  import ParticipationItem from './ParticipationItem.vue'
  import ParticipationForm from './ParticipationForm.vue'

  export default {
    name: 'ParticipationList',
    components: {ParticipationForm, ParticipationItem},
    props: ['participations', 'sportsmanId']
  }
</script>

<style scoped>

</style>