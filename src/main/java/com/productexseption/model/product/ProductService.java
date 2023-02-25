package com.productexseption.model.product;

import com.productexseption.core.page_request.PageableRequest;
import com.productexseption.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product> monitoring(PageableRequest pageableRequest);
    Product create(Product product);
    Product update(Long id, Product product) throws ResourceNotFoundException;
    List<ProductResponse> getAll();
    Product getId(Long id) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
