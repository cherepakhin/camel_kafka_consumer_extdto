package ru.perm.v.camel.kafka.consumer_extdto.service.processor

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProcessorStringTest {

    @Test
    fun process() {
        val processor = ProcessorString()
        val result = processor.process("test")
        assertEquals("test", result)
    }
}