#!/bin/bash

#$1 - topic for send
~/tools/kafka/bin/kafka-console-producer.sh --bootstrap-server 192.168.1.20:9092 --topic $1