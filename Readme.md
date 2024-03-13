## Camel consumer Kafka for ExtDTO 

Library ExtDto [https://github.com/cherepakhin/shop_kotlin_extdto](https://github.com/cherepakhin/shop_kotlin_extdto/tree/main/src/main/kotlin/ru/perm/v/shopkotlin/extdto)

Api port(defined in application.yaml): ${API_PORT:8992}. For setting:

````shell
export API_PORT=9999
````

Spring Actuator: http://127.0.0.1:8998/camel_kafka_consumer_extdto/api/actuator

Environment variables:

"KAFKA_SERVER" ip address Kafka server []

Set variable:

````shell
export KAFKA_SERVER=192.168.1.20
````

REST URL: /camel_kafka_consumer_extdto/api

Swagger: http://127.0.0.1:8992/camel_kafka_consumer_extdto/api/swagger-ui/index.html

![swagger](doc/swagger.png)