package ru.perm.v.camel.kafka.consumer_extdto.ctrl

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * test http http://127.0.0.1:8990/camel_kafka_consumer_extdto/api/echo/aaa
 */
@RestController
@RequestMapping("/echo")
@Api(tags = ["Echo for test"])
class EchoCtrl {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    @GetMapping("/{msg}")
    @ApiOperation("Short description echo")
    fun echo(
        @PathVariable("msg")
        @ApiParam(name = "msg", value = "any string") msg: String,
    ): String {
        logger.info("echo: $msg")
        return msg
    }
}