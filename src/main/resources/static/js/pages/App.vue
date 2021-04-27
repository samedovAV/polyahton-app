<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>Polyathlon App</v-toolbar-title>
      <v-btn
          text
          v-if="profile"
          :disabled="$route.path === '/'"
          @click="showSportsmen">
        Спортсмены
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn text
             v-if="profile"
             :disabled="$route.path === '/profile'"
             @click="showProfile">
        {{profile.name}}
      </v-btn>
      <v-btn v-if="profile" icon href="/logout">
        <v-icon>logout</v-icon>
      </v-btn>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
    import  { mapState, mapMutations } from 'vuex'
    import { addHandler } from 'util/ws'

    export default {
      computed: mapState(['profile']),
      methods: {
        ...mapMutations(['addSportsmanMutation', 'updateSportsmanMutation', 'removeSportsmanMutation']),
        showSportsmen() {
          this.$router.push('/')
        },
        showProfile() {
          this.$router.push('/profile')
        }
      },
      created() {
        addHandler(data => {
          if (data.objectType === 'SPORTSMAN') {
            switch (data.eventType) {
              case 'CREATE':
                this.addSportsmanMutation(data.body)
                break
              case 'UPDATE':
                this.updateSportsmanMutation(data.body)
                break
              case 'REMOVE':
                this.removeSportsmanMutation(data.body)
                break
              default:
                console.error(`event type unknown "${data.eventType}"`)
            }
          } else {
            console.error(`object type unknown "${data.objectType}"`)
          }
        })
      },
      beforeMount() {
        if (!this.profile) {
          this.$router.replace('/auth')
        }
      }
    }
</script>

<style>

</style>