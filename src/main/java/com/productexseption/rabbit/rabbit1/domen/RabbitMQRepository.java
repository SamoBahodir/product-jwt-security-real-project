package com.productexseption.rabbit.rabbit1.domen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RabbitMQRepository extends JpaRepository<RabbitMQ,Long> {
}
