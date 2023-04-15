package com.productexseption.rabbit.rabbit2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class LegalEntity2 {
    @Id
    @SequenceGenerator(name = "legal_entity_seq_id", sequenceName = "legal_entity_seq_id", allocationSize = 1)
    @GeneratedValue(generator = "legal_entity_seq_id", strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String phone;
}
