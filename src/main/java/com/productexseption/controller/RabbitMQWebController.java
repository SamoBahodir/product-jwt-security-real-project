package com.productexseption.controller;

import com.productexseption.config.SwaggerConfig;
import com.productexseption.rabbit.rabbit1.comsumer.RabbitMQSender;
import com.productexseption.core.dto.LegalEntityIntegrationPayload;
import com.productexseption.rabbit.rabbit1.entity.LegalEntityService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/rabbitmq")
@SecurityRequirement(name = SwaggerConfig.BEARER)
public class RabbitMQWebController {

    private final RabbitMQSender sender;
    private final LegalEntityService service;

    @PostMapping(value = "/producer")
    public String producer(@RequestBody LegalEntityIntegrationPayload payload) {
        service.save(payload);
        sender.convertAndSendJournal(payload.getEmail(), payload.getPhone());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}