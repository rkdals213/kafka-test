package com.example.servera

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val service: Service
) {
    @GetMapping
    fun heartBeat(): String {
        service.kafkaMessage("테스트 메세지")
        return "OK"
    }
}