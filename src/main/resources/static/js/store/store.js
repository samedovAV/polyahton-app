import Vue from 'vue'
import Vuex from 'vuex'
import sportsmenApi from 'api/sportsmen'
import participationApi from 'api/participation'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        sportsmen: frontendData.sportsmen,
        profile: frontendData.profile
    },
    getters: {
        sortedSportsmen: state => (state.sportsmen || []).sort((a, b) => -(a.id - b.id))
    },
    mutations: {
        addSportsmanMutation(state, sportsman) {
            state.sportsmen = [
                ...state.sportsmen,
                sportsman
            ]
        },
        updateSportsmanMutation(state, sportsman) {
            const updateIndex = state.sportsmen.findIndex(item => item.id === sportsman.id)

            state.sportsmen = [
                ...state.sportsmen.slice(0, updateIndex),
                sportsman,
                ...state.sportsmen.slice(updateIndex + 1)
            ]
        },
        removeSportsmanMutation(state, sportsman) {
            const deletionIndex = state.sportsmen.findIndex(item => item.id === sportsman.id)

            if (deletionIndex > -1) {
                state.sportsmen = [
                    ...state.sportsmen.slice(0, deletionIndex),
                    ...state.sportsmen.slice(deletionIndex + 1)
                ]
            }
        },
    },
    actions: {
        async addSportsmanAction({commit, state}, sportsman) {
            const result = await sportsmenApi.add(sportsman)
            const data = await result.json()
            const index = state.sportsmen.findIndex(item => item.id === data.id)

            if (index > -1) {
                commit('updateSportsmanMutation', data)
            } else {
                commit('addSportsmanMutation', data)
            }
        },
        async updateSportsmanAction({commit}, sportsman) {
            const result = await sportsmenApi.update(sportsman)
            const data = await result.json()

            commit('updateSportsmanMutation', data)
        },
        async removeSportsmanAction({commit}, sportsman) {
            const result = await sportsmenApi.remove(sportsman.id)

            if (result.ok) {
                commit('removeSportsmanMutation', sportsman)
            }
        }
    }
})