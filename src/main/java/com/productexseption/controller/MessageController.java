package com.productexseption.controller;

import com.productexseption.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer producer;

    @GetMapping("/user")
    public String getUser(@RequestParam(name = "message") String message) {
        producer.sendMessage(message);
        return "Hello User";
    }
}
