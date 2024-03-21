~/tools/kafka/bin/kafka-configs.sh --alter --zookeeper zookeeper:2181 --entity-type topics --entity-name test-topic --add-config retention.ms=1000

~/tools/kafka/bin/kafka-configs.sh --alter --zookeeper 127.0.0.1:2181 --entity-type topics --entity-name test-topic --add-config retention.ms=1000
~/tools/kafka/bin/kafka-configs.sh --alter --zookeeper 127.0.0.1:2181 --entity-name test-topic --add-config retention.ms=1000

~/tools/kafka/bin/kafka-configs.sh --bootstrap-server 127.0.0.1:2181 --entity-type topics --entity-name test-topic --add-config retention.ms=1000
~/tools/kafka/bin/kafka-configs.sh --bootstrap-server 127.0.0.1:2181 --entity-type topics --entity-name test-topic --add-config retention.ms=1000

~/tools/kafka/bin/kafka-configs.sh --bootstrap-server 127.0.0.1:2181 --entity-type topics --topic test-topic --add-config retention.ms=1000
~/tools/kafka/bin/kafka-configs.sh --bootstrap-server 127.0.0.1:2181 --entity-type topics --topic product_ext_dto --add-config retention.ms=1000
product_ext_dto
ERROR:
~/tools/kafka/bin/kafka-configs.sh --alter --zookeeper 127.0.0.1:2181 --entity-type topics --entity-name test-topic --add-config retention.ms=1000