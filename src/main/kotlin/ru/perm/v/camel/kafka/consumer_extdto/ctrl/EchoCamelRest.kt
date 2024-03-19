package ru.perm.v.camel.kafka.consumer_extdto.ctrl

import org.apache.camel.builder.RouteBuilder

class EchoCamelRest: RouteBuilder() {
    override fun configure() {
        rest("/echo_camel_rest").get("/").to("direct:echo")
    }
}