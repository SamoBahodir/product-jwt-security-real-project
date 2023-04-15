package com.productexseption.rabbit.rabbit1.domen;

import com.productexseption.core.dto.LegalEntityIntegrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
@RequiredArgsConstructor()
public class RabbitMQService {
    private final RabbitMQRepository repository;

    public RabbitMQ save(LegalEntityIntegrationRequest request) {
        RabbitMQ employee = new RabbitMQ();
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());

        return repository.save(employee);
    }


}
