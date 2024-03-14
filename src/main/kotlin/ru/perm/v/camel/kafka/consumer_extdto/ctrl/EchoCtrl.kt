package ru.perm.v.camel.kafka.consumer_extdto.ctrl

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/echo")
@Api(tags = ["Echo for test"])
class EchoCtrl {
    @GetMapping("/{msg}")
    @ApiOperation("Short description echo")
    fun echo(
        @PathVariable("msg")
        @ApiParam(name = "msg", value = "any string") msg: String,
    ): String {
        return msg
    }
}