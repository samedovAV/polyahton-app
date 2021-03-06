import SockJS from 'sockjs-client'
import { Stomp } from '@stomp/stompjs'

let stompClient = null
const handlers = []

export function connect() {
    stompClient = Stomp.over(() => new SockJS('/gs-guide-websocket'));
    stompClient.debug = () => {}
    stompClient.connect({}, frame => {
        stompClient.subscribe('/topic/activity', sportsman => {
            handlers.forEach(handler => handler(JSON.parse(sportsman.body)))
        })
    })
}

export function addHandler(handler) {
    handlers.push(handler)
}

export function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    console.log("Disconnected")
}

export function sendSportsman(sportsman) {
    stompClient.send("/app/changeSportsman", {}, JSON.stringify(sportsman))
}