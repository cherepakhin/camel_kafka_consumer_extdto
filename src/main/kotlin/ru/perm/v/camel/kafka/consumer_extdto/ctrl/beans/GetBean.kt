package ru.perm.v.camel.kafka.consumer_extdto.ctrl.beans

import org.springframework.stereotype.Component

@Component
class GetBean {
    fun get(): String {
        return "From GetBean"
    }
}