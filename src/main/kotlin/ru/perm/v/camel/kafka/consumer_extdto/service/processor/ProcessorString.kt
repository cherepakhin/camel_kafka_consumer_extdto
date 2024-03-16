package ru.perm.v.camel.kafka.consumer_extdto.service.processor

import org.slf4j.LoggerFactory

class ProcessorString {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    fun process(s: String): String {
        logger.info("ProcessorString received: $s")
        return s
    }
}