package com.productexseption.model.product;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductPayload {
    private String name;
    private String description;
    private BigDecimal price;
    private Date createdAt;
    private Date updatedAt;
}
