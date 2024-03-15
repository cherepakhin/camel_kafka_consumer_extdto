package ru.perm.v.camel.kafka.consumer_extdto.service

import org.slf4j.LoggerFactory
import ru.perm.v.shopkotlin.extdto.ProductExtDTO

class UserProductExtDtoService {

    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    fun processMethod(product: ProductExtDTO): ProductExtDTO {
        logger.info(product.toString())
        return product
    }
}