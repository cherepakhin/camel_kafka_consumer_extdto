package ru.perm.v.camel.kafka.consumer_extdto.ctrl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EchoCtrlTest {
    @Test
    fun echo() {
        val result= EchoCtrl().echo("TEST_MSG")
        assertEquals("TEST_MSG", result)
    }
}