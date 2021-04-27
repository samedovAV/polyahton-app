import Vue from 'vue'

const participations = Vue.resource('/participation{/id}')

export default {
    add: participation => participations.save({}, participation)
}