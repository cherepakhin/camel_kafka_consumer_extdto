package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ReceiverSpringBean : IReceiverSpringBean {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    override fun receive(message: String): String {
        logger.info("ReceiverSpringBean received: $message")
        return message
    }
}