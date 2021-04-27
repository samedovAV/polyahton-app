<template>
    <v-row>
        <v-text-field
            label="Regular"
            placeholder="Placeholder"
            v-model="firstName"
            append-icon="save"
            @click:append="save"
            @keyup.enter="save"
        />
    </v-row>
</template>

<script>

import { mapActions } from 'vuex'

export default {
    props: [ 'sportsmanAttr' ],
    data() {
        return {
            firstName: '',
            id: ''
        }
    },
    watch: {
        sportsmanAttr(newVal, oldVal) {
            this.firstName = newVal.firstName;
            this.id = newVal.id;
        }
    },
    methods: {
        ...mapActions(['addSportsmanAction', 'updateSportsmanAction']),
        save() {
          const sportsman = {
            id: this.id,
            firstName: this.firstName };

          if (this.id) {
            this.updateSportsmanAction(sportsman)
          } else {
            this.addSportsmanAction(sportsman)
          }
          this.firstName = ''
          this.id = ''
        }
    }
}
</script>

<style>

</style>