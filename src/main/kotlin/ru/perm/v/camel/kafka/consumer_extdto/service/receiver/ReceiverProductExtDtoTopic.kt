package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

import org.apache.camel.builder.RouteBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.perm.v.camel.kafka.consumer_extdto.service.UserProductExtDtoService
import ru.perm.v.camel.kafka.consumer_extdto.service.processor.ProductCamelProcessor

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
// "from()" read from kafka queue, return JSON String
        from("kafka:$PRODUCT_EXT_DTO_TOPIC?brokers=$KAFKA_HOST")
            .log("ReceiverProductExtDtoTopic. Camel \"from\" received from Kafka queue ${PRODUCT_EXT_DTO_TOPIC} body=\${body}")
// Method 1 usage BEAN. Send to bean. Bean defined as string.
// it will be convert String to ProductExtDto defined in external library: implementation("ru.perm.v:shop_kotlin_extdto"
// MapperProductExtDto is NO REQUIRES dependence Camel.
// method fromJson() receive JSON String and convert to ProductExtDto
            .to("bean:ru.perm.v.camel.kafka.consumer_extdto.mapper.MapperProductExtDto?method=fromJson")
// UserProductExtDtoService{ fun processMethod(product: ProductExtDTO): ProductExtDTO {...}}
// Method 2 usage BEAN. Send to bean with class and method.
// UserProductExtDtoService does NOT REQUIRES dependence Camel.
// function .bean() equals .to(), but use simple class with any method and return any object.
// BUT method name as STRING VALUE(!).
            .bean(UserProductExtDtoService::class.java, "processMethod")
// Method 3 usage BEAN. Send bean to processor (implemented Processor).
// Processor have default method process(exchange: Exchange?).
// ProductCamelProcessor REQUIRES dependence Camel.
// function .bean() equals .to()
            .bean(ProductCamelProcessor::class.java)
            .log("ReceiverProductExtDtoTopic. Converted messages: \${body}") // body is object ProductExtDto
//            .to("kafka:processed-orders")
    }
}