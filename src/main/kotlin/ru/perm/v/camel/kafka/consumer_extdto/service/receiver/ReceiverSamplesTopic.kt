package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component
import ru.perm.v.camel.kafka.consumer_extdto.service.processor.ProcessorStringBean

/**
 * Camel route to receive messages from kafka and PROCESS them (send to ProcessorString)
 * Sending string through __bean__ (__BEAN__ ProcessorString)
 */
@Component
class ReceiverSamplesTopic: RouteBuilder() {
    val TOPIC="samples"
    val KAFKA_HOST = "192.168.1.20:9092"
    override fun configure() {
        from("kafka:$TOPIC?brokers=$KAFKA_HOST")
            .log("Received messages: \${body}")
            .bean(ProcessorStringBean::class.java, "process") // seng to ProcessorStringBean.process(string)
//            .to("kafka:processed-orders")
    }
}