package ru.perm.v.camel.kafka.consumer_extdto.mapper

import org.slf4j.LoggerFactory
import ru.perm.v.shopkotlin.extdto.ProductExtDTO
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class MapperProductExtDto {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    val mapper = jacksonObjectMapper()

    fun fromJson(json: String): ProductExtDTO {
        val productExtDto= mapper.readValue(json, ProductExtDTO::class.java)
        logger.info("ProcessorProductExtDto received: $productExtDto")
        return productExtDto
    }

}