package com.productexseption.rabbit.rabbit1.entity;

import com.productexseption.core.dto.LegalEntityIntegrationPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LegalEntityService {
    private final LegalEntityRepository repository;

    public LegalEntity save(LegalEntityIntegrationPayload payload) {
        LegalEntity legalEntity = new LegalEntity();
        legalEntity.setEmail(payload.getEmail());
        legalEntity.setPhone(payload.getPhone());
        return repository.save(legalEntity);
    }
}
