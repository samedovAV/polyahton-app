import Vue from 'vue'

const sportsmen = Vue.resource('/sportsman{/id}')

export default {
    add: sportsman => sportsmen.save({}, sportsman),
    update: sportsman => sportsmen.update({id: sportsman.id}, sportsman),
    remove: id => sportsmen.remove({id})
}
