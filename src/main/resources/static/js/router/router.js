import Vue from 'vue'
import VueRouter from 'vue-router'
import SportsmenList from 'pages/SportsmenList.vue'
import Auth from 'pages/Auth.vue'
import Profile from 'pages/Profile.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: SportsmenList },
    { path: '/auth', component: Auth },
    { path: '/profile', component: Profile },
    { path: '*', component: SportsmenList },
]

export default new VueRouter({
    mode: 'history',
    routes
})