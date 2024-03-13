package ru.perm.v.camel.kafka.consumer_extdto

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/echo")
class EchoCtrl {
    @GetMapping("/{msg}")
    @Operation(summary = "SUmmurize echo", description = "Descripion echo")
    fun echo(
        @PathVariable("msg")
        msg: String,
    ): String {
        return msg
    }
}