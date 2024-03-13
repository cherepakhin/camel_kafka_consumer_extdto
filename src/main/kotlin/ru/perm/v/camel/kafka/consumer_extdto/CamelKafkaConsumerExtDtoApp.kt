package ru.perm.v.camel.kafka.consumer_extdto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamelKafkaConsumerExtDtoApp {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<CamelKafkaConsumerExtDtoApp>(*args)
		}
	}
}

