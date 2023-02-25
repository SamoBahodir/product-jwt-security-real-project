package com.productexseption.model.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Date createdAt;
    private Date updatedAt;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }

    public ProductResponse(List<Product> product) {
        List<Product> array=new ArrayList<>();
        for (Product product1 : product) {
            this.id = product1.getId();
            this.name = product1.getName();
            this.description = product1.getDescription();
            this.price = product1.getPrice();
            this.createdAt = product1.getCreatedAt();
            this.updatedAt = product1.getUpdatedAt();
            array.add(product1);
        }
    }
}
