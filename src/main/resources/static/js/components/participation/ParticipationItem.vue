<template>
  <v-card
      class="mx-auto"
  >
    <template>
      <v-list-item-content>
        <v-list-item-title>{{ participation.name }}</v-list-item-title>
      </v-list-item-content>
    </template>

    <v-list-item>
      <v-list-item-content>
        <v-list-item-title>{{ participation.name }}</v-list-item-title>
      </v-list-item-content>
    </v-list-item>
  </v-card>
</template>

<script>
export default {
  name: 'ParticipationItem',
  props: ['participation']
}
</script>

<style scoped>

</style>