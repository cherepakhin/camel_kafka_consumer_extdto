## Camel consumer Kafka for ExtDTO 

Simple receive messages (text, json) from Kafka queue wit Camel.

[Environment variables:
__APP_CAMEL_KAFKA_CONSUMER_API_PORT__ - __REST API__ port __application__ (defult value 8994).

Library ExtDto [https://github.com/cherepakhin/shop_kotlin_extdto](https://github.com/cherepakhin/shop_kotlin_extdto/tree/main/src/main/kotlin/ru/perm/v/shopkotlin/extdto)

Spring Actuator: http://127.0.0.1:8998/camel_kafka_consumer_extdto/api/actuator (__port: 8998__)

REST URL: /camel_kafka_consumer_extdto/api

Swagger: http://127.0.0.1:__APP_CAMEL_KAFKA_CONSUMER_API_PORT__/camel_kafka_consumer_extdto/api/swagger-ui/index.html
(default http://127.0.0.1:8994/camel_kafka_consumer_extdto/api/swagger-ui/index.html)

![swagger](doc/swagger.png)

## Test

Generate messages and __send__ to topic "product_ext_dto":

````shell
$ ./send_many_messages.sh 10000
````

Run project for read messages:

````shell
./gradlew bootRun
````

Log:

````shell
INFO --- [product_ext_dto]] route1                                   : Received messages: {"n":1,"name":"NAME_1","groupDtoN":1}

....

INFO --- [product_ext_dto]] r.p.v.c.k.c.mapper.MapperProductExtDto   : ProcessorProductExtDto received: ProductExtDTO(n=9999, name='NAME_9999', groupDtoN=9999)
INFO --- [product_ext_dto]] route1                                   : Converted messages: ProductExtDTO(n=9999, name='NAME_9999', groupDtoN=9999)

````
