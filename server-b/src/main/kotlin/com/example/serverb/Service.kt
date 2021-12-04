package com.example.serverb

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service {
    @KafkaListener(topics = ["a-to-b"])
    @Transactional
    fun receiveCreateMessage(message: String?, ack: Acknowledgment) {
        try {
            println(message)
            ack.acknowledge()
        } catch (e: Exception) {
            println("ERROR")
            throw RuntimeException(e)
        }
    }
}