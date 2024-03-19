package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Read from topic "simple topic" with params from application.yml
 */
@Component
class ReceiverWithParamsYAML: RouteBuilder() {
    override fun configure() {
        from("kafka:{{myconfig.paramTextTopic}}?brokers={{myconfig.kafkaHost}}")
            .log("ReceiverWithParamsYAML. Camel \"from\" received from Kafka queue \"{{myconfig.paramTextTopic}}\" body=\${body}")
    }
}