package ru.perm.v.camel.kafka.consumer_extdto.ctrl.beans

import org.springframework.stereotype.Component

@Component
class HelloBean {
    fun hello(): ResponseType {
        return ResponseType("Hello")
    }
}