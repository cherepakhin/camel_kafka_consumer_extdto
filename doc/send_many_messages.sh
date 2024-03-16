#!/bin/bash

# for test send many messages to queue `product_ext_dto_topic`  and view in console received messages
# run from ~/prog/kotlin/camel/camel_kafka_consumer_extdto/doc/send_many_messages.sh
# cd ~/prog/kotlin/camel/camel_kafka_consumer_extdto/doc/
# ./send_many_messages.sh 100
# {"n":1,"name":"NAME_1","groupDtoN":1}
# {"n":1,"name":"NAME_1","groupDtoN":1}
# {"n":1,"name":"NAME_1","groupDtoN":1}


cat /dev/null > ./product_list.json

# count_messages = 100
# Count messages for send. Use: shop_kafka_consumer/doc$ ./send_many_messages.sh 200
count_messages=$1

# generate messages
for ((i=0; i < count_messages; i++))
do
  echo "{\"n\":$i,\"name\":\"NAME_$i\",\"groupDtoN\":$i}" >> ./product_list.json
done

# send json to queue.
# product_ext_dto - topic for send messages
./run-producer.sh product_ext_dto < ./product_list.json
