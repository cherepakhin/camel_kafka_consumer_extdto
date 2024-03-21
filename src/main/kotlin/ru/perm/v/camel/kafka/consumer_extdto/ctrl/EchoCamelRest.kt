package ru.perm.v.camel.kafka.consumer_extdto.ctrl

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * example from https://tomd.xyz/camel-rest/
 */
@Component
class EchoCamelRest : RouteBuilder() {
    override fun configure() {
//        restConfiguration().component("servlet").port(8994).host("127.0.0.1").bindingMode(RestBindingMode.json);

        rest().get("/hello_camel").produces(MediaType.APPLICATION_JSON_VALUE).to("direct:hello");


        from("direct:hello")
            .transform().simple("Hello World");

        from("direct:bye")
            .transform().constant("Bye World");
    }
}