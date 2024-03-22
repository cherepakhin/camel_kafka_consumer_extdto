package ru.perm.v.camel.kafka.consumer_extdto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages= arrayOf("ru.perm.v.camel.kafka.consumer_extdto.service.receiver"))
class CamelKafkaConsumerExtDtoApp {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<CamelKafkaConsumerExtDtoApp>(*args)
		}
	}
}

