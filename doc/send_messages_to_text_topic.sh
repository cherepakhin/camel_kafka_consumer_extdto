#!/bin/bash

# run from project root
# for test ReceiverWithParamsYAML.kt
# Use: camel_kafka_consumer_extdto$ doc/send_messages_to_param_topic.sh 200

cat /dev/null > ./doc/messages.txt

# count_messages = 100
count_messages=$1

# generate messages
for ((i=0; i < count_messages; i++))
do
  echo "message_"$i >> ./doc/messages.txt
done

# send json to queue.
# param_text_topic - topic for received messages
./doc/run_producer.sh text_topic < ./doc/messages.txt
