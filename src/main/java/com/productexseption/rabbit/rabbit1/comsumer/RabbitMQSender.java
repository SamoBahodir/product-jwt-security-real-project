package com.productexseption.rabbit.rabbit1.comsumer;

import com.productexseption.rabbit.rabbit1.domen.RabbitMQService;
import com.productexseption.core.dto.LegalEntityJournalRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQService service;

    public void convertAndSendJournal(String email, String phone) {
        var request = getRegisterRequestTax(email, phone);
        rabbitTemplate.convertAndSend(CommonConfig.RABBIT1_LEGAL_ENTITY_REQUEST, CommonConfig.ROUTING_KEY, request);
    }

    private LegalEntityJournalRequest getRegisterRequestTax(String email, String phone) {
        var request = new LegalEntityJournalRequest();
        request.setEmail(email);
        request.setPhone(phone);
        return request;
    }

//    @RabbitListener(queues = AmqpConfig.RABBIT1_LEGAL_ENTITY_INTEGRATION_RESPONSE, containerFactory = "applicationListenerContainerFactory")
//    public void journalLegalEntityRegisterRequest(LegalEntityIntegrationRequest request) {
//        log.debug("register legal amqp request: {}", request);
//        service.save(request);
//    }
}