package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component
import ru.perm.v.camel.kafka.consumer_extdto.mapper.MapperProductExtDto

/**
 * Receiver ProductExtDto frm Kafka Topic product_ext_dto
 *
 * for manual test receiver, send to kafka through console:
 * $ ~/tools/kafka/bin/kafka-console-producer.sh --bootstrap-server 192.168.1.20:9092 --topic product-ext-dto
 * >{"n":10,"name":"NAME_10","groupDtoN":100}
 */
@Component
class ReceiverProductExtDtoTopic: RouteBuilder() {
    val TOPIC="product_ext_dto"
    val KAFKA_HOST = "192.168.1.20:9092"
    override fun configure() {
        from("kafka:$TOPIC?brokers=$KAFKA_HOST")
            .log("Received messages: \${body}")
            .bean(MapperProductExtDto::class.java, "fromJson")
            .log("Converted messages: \${body}")
//            .to("kafka:processed-orders")
    }
}