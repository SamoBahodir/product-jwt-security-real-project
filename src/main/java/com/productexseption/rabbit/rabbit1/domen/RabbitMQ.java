package com.productexseption.rabbit.rabbit1.domen;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rabbit_mq")
public class RabbitMQ {
    @Id
    @SequenceGenerator(sequenceName = "", name = "", allocationSize = 1)
    @GeneratedValue(generator = "", strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String phone;
}
