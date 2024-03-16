package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ReceiverSpringBeanTest {

    @Test
    fun receive() {
        val bean = ReceiverSpringBean()
        assertEquals("MESSAGE", bean.receive("MESSAGE"))
    }
}