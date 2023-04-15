package com.productexseption.rabbit.rabbit2.entity;

import com.productexseption.rabbit.rabbit1.comsumer.CommonConfig;
import com.productexseption.core.dto.LegalEntityIntegrationRequest;
import com.productexseption.core.dto.LegalEntityJournalRequest;
import com.productexseption.rabbit.rabbit2.comsumer.AmqpConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LegalEntityService2 {
    private final LegalEntityRepository2 repository;
    private final RabbitTemplate rabbitTemplate;


    public void save(LegalEntityIntegrationRequest request) {
        try {
            var entity2 = new LegalEntity2();
            entity2.setEmail(request.getEmail());
            entity2.setPhone(request.getPhone());
            repository.save(entity2);
            convertAndSendJournal(request.getEmail(), request.getPhone());
        } catch (Exception exception) {
            log.error("Save error ", exception);
        }
    }


    public void convertAndSendJournal(String email, String phone) {
        var request = getRegisterRequestTax(email, phone);
        rabbitTemplate.convertAndSend(AmqpConfig.RABBIT1_LEGAL_ENTITY_RESPONSE, CommonConfig.ROUTING_KEY, request);
    }

    private LegalEntityJournalRequest getRegisterRequestTax(String email, String phone) {
        var request = new LegalEntityJournalRequest();
        request.setEmail(email);
        request.setPhone(phone);
        return request;
    }
}
