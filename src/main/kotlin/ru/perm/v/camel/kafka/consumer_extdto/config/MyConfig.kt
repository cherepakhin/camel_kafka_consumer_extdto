package ru.perm.v.camel.kafka.consumer_extdto.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * User configuration in application.yml. For define use:
 * myconfig:
 *   kafkaHost: 192.168.1.20:9092
 *   productExtDtoTopic: "product_ext_dto"
 *
 * For example see ru.perm.v.camel.kafka.consumer_extdto.service.receiver.ReceiverProductExtDtoTopic.kt
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "myconfig")
data class MyConfig(
    val kafkaHost: String,
    val productExtDtoTopic: String,
)