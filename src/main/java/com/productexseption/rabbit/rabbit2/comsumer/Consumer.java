package com.productexseption.rabbit.rabbit2.comsumer;

import com.productexseption.core.dto.LegalEntityIntegrationRequest;
import com.productexseption.rabbit.rabbit2.entity.LegalEntityService2;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Consumer {

    private final LegalEntityService2 service;

    @RabbitListener(queues = AmqpConfig.RABBIT1_LEGAL_ENTITY_REQUEST, containerFactory = "applicationListenerContainerFactory")
    public void journalLegalEntityRegisterRequest(LegalEntityIntegrationRequest request) {
        log.debug("register legal amqp request: {}", request);
        service.save(request);

    }
}
