package ru.perm.v.camel.kafka.consumer_extdto.service.processor

import org.slf4j.LoggerFactory
import ru.perm.v.camel.kafka.consumer_extdto.mapper.MapperProductExtDto
import ru.perm.v.shopkotlin.extdto.ProductExtDTO

class ProcessorProductExtDto {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    val mapperProductExtDto = MapperProductExtDto()

    fun process(s: String): ProductExtDTO {
        logger.info("ProcessorString received: $s")
        return mapperProductExtDto.fromJson(s)
    }
}