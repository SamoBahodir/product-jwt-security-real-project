package com.productexseption.model.product;

import com.productexseption.exception.ResourceNotFoundException;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Long id, Product product) throws ResourceNotFoundException;
    List<Product> getAll();
    Product getId(Long id) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
