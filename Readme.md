## Camel consumer Kafka for ExtDTO 

Simple receive messages (text and json) from Kafka queue with Camel.

[Environment variables:
__APP_CAMEL_KAFKA_CONSUMER_API_PORT__ - __REST API__ port __application__ (defult value 8994).

Library ExtDto [https://github.com/cherepakhin/shop_kotlin_extdto](https://github.com/cherepakhin/shop_kotlin_extdto/tree/main/src/main/kotlin/ru/perm/v/shopkotlin/extdto)

Spring Actuator: http://127.0.0.1:8998/camel_kafka_consumer_extdto/api/actuator (__port: 8998__)

REST URL: /camel_kafka_consumer_extdto/api

Swagger: http://127.0.0.1:__APP_CAMEL_KAFKA_CONSUMER_API_PORT__/camel_kafka_consumer_extdto/api/swagger-ui/index.html
(default http://127.0.0.1:8994/camel_kafka_consumer_extdto/api/swagger-ui/index.html)

![swagger](doc/swagger.png)

# Variants send to 
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

## User defined variables in application.yaml

Example of definition [MyConfig.kt](https://github.com/cherepakhin/camel_kafka_consumer_extdto/blob/main/src/main/kotlin/ru/perm/v/camel/kafka/consumer_extdto/config/MyConfig.kt)

````shell
myconfig:
  kafkaHost: 192.168.1.20:9092
  productExtDtoTopic: "product_ext_dto"
  
````

For an example of use, see [ReceiverProductExtDtoTopic.kt](https://github.com/cherepakhin/camel_kafka_consumer_extdto/blob/main/src/main/kotlin/ru/perm/v/camel/kafka/consumer_extdto/service/receiver/ReceiverProductExtDtoTopic.kt)

<a id="create_runable"></a>
### Create runable jar

Build:

````shell
./gradlew bootJar
````
(**bootJar**, NOT **bootRun!!!**)

builded jar in **./build/libs/**

run with limit RAM 256Mb:

````shell
shop_kotlin/$ java -Xmx256M -jar build/libs/camel_kafka_consumer_extdto-0.24.0313.1.jar
````

or:

````shell
cd shop_kotlin/build/libs 
shop_kotlin/build/libs$ java -Xmx256M -jar shop_kotlin-0.1.20.jar
````
### Jenkins pipeline

[Jenkinsfile](https://github.com/cherepakhin/camel_kafka_consumer_extdto/blob/main/Jenkinsfile)

![jenkins_pipeline](doc/jenkins_pipeline.png)

### Demo Camel Route

4 examples Camel Route in [ru.perm.v.camel.kafka.consumer_extdto.service.receiver.ReceiverProductExtDtoTopic.kt](https://github.com/cherepakhin/camel_kafka_consumer_extdto/blob/main/ru/perm/v/camel/kafka.consumer_extdto/service/receiver/ReceiverProductExtDtoTopic.kt)

````kotlin
@Component
class ReceiverProductExtDtoTopic: RouteBuilder() {
    // Example: val KAFKA_HOST = "192.168.1.20:9092"
    @Value("{\${myconfig.kafkaHost}")
    lateinit var KAFKA_HOST:String
    // Example: val PRODUCT_EXT_DTO_TOPIC="product_ext_dto"
    @Value("\${myconfig.productExtDtoTopic}")
    lateinit var PRODUCT_EXT_DTO_TOPIC:String
    @Autowired
    lateinit var receiverSpringBean: IReceiverSpringBean
    override fun configure() {
// "from()" read from kafka queue, return JSON String
        from("kafka:$PRODUCT_EXT_DTO_TOPIC?brokers=$KAFKA_HOST")
            .log("ReceiverProductExtDtoTopic. Camel \"from\" received from Kafka queue ${PRODUCT_EXT_DTO_TOPIC} body=\${body}")
// Method 1 usage BEAN. Send to bean. Bean defined as string.
// it will be convert String to ProductExtDto defined
//      in external library: implementation("ru.perm.v:shop_kotlin_extdto".
// MapperProductExtDto is NOT REQUIRES dependence Camel.
//      method fromJson() simple receive JSON String and convert to ProductExtDto
            .to("bean:ru.perm.v.camel.kafka.consumer_extdto.mapper.MapperProductExtDto?method=fromJson")
// Method 2 usage BEAN. Send to bean with class and method.
// UserProductExtDtoService{ fun processMethod(product: ProductExtDTO): ProductExtDTO {...}}
// UserProductExtDtoService does NOT REQUIRES dependence Camel.
// function .bean() like .to(), but use simple class with any method and return any object.
// BUT method name is STRING VALUE(!).
            .bean(UserProductExtDtoService::class.java, "processMethod")
// Method 3 usage BEAN. Send bean to processor (need implemented Processor).
// Processor have default method process(exchange: Exchange?).
// ProductCamelProcessor REQUIRES dependence Camel.
// function .bean() like .to()
            .bean(ProductCamelProcessor::class.java)
// Method 4 usage BEAN. Send to autowired SPRING BEAN
            .bean(receiverSpringBean, "receive")
            .log("ReceiverProductExtDtoTopic. Converted messages: \${body}") // body is object ProductExtDto
//            .to("kafka:processed-orders")
    }
}
````