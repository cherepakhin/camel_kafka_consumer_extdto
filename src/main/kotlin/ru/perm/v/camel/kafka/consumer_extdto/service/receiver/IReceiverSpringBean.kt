package ru.perm.v.camel.kafka.consumer_extdto.service.receiver

interface IReceiverSpringBean {
    fun receive(message: String): String;
}