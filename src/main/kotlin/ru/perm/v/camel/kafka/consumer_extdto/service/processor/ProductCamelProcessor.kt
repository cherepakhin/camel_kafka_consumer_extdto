package ru.perm.v.camel.kafka.consumer_extdto.service.processor

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.slf4j.LoggerFactory
import ru.perm.v.shopkotlin.extdto.ProductExtDTO

/**
 * Simple processor for change name input bean
 */
class ProductCamelProcessor : Processor {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    override fun process(exchange: Exchange?) {
//        val body = exchange!!.getIn().getBody(String::class.java)
        val productExtDTO = exchange!!.getIn().getBody(ProductExtDTO::class.java)
        logger.info("ProductCamelProcessor body=$productExtDTO")
        // change body
        productExtDTO.name = "CHANGED_" + productExtDTO.name
        exchange.getIn().body = productExtDTO
    }
}