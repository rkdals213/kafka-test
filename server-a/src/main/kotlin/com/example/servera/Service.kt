package com.example.servera

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Service(
    private val kafkaTemplate: KafkaTemplate<String, String>)
{
    fun kafkaMessage(message: String) {
        println("kafka send")
        try {
            kafkaTemplate.send("a-to-b", message)
        } catch (e: Exception) {
            println("ERROR")
            throw RuntimeException(e)
        }
    }
}