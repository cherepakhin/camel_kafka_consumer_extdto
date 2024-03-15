package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.apache.camel.builder.RouteBuilder
import org.springframework.beans.factory.annotation.Value
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
    // Example: val KAFKA_HOST = "192.168.1.20:9092"
    @Value("{\${myconfig.kafkaHost}")
    lateinit var KAFKA_HOST:String
    // Example: val PRODUCT_EXT_DTO_TOPIC="product_ext_dto"
    @Value("\${myconfig.productExtDtoTopic}")
    lateinit var PRODUCT_EXT_DTO_TOPIC:String

    override fun configure() {
        from("kafka:$PRODUCT_EXT_DTO_TOPIC?brokers=$KAFKA_HOST")
            .log("Received messages: \${body}")
            .bean(MapperProductExtDto::class.java, "fromJson") // return ProductExtDto from external library implementation("ru.perm.v:shop_kotlin_extdto:$shopKotlinExtDtoVersion")
            .log("Converted messages: \${body}") // body is object ProductExtDto
//            .to("kafka:processed-orders")
    }
}