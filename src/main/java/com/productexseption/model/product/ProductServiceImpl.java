package com.productexseption.model.product;

import com.productexseption.core.page_request.PageableRequest;
import com.productexseption.core.page_request.PageableRequestUtil;
import com.productexseption.core.page_request.SearchSpecification;
import com.productexseption.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Product> monitoring(PageableRequest pageableRequest) {
        return repository.findAll(new SearchSpecification<>(pageableRequest.getSearch()),
                PageableRequestUtil.toPageable(pageableRequest));
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) throws ResourceNotFoundException {
        Optional<Product> byId = repository.findById(id);
        if (byId.isPresent()) {
            Product update = byId.get();
            update.setUpdatedAt(product.getUpdatedAt());
            update.setDescription(product.getDescription());
            update.setPrice(product.getPrice());
            update.setName(product.getName());
            update.setCreatedAt(product.getCreatedAt());
            return repository.save(update);
        } else throw new ResourceNotFoundException("Record not found with id" + product.getId());
    }

    @Override
    public List<ProductResponse> getAll() {
        return repository.findAll().stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setName(product.getName());
            response.setCreatedAt(product.getCreatedAt());
            response.setUpdatedAt(product.getUpdatedAt());
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public Product getId(Long id) throws ResourceNotFoundException {
        Optional<Product> byId = repository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else throw new ResourceNotFoundException("Record not found with id" + byId.get().getId());
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Product> byId = repository.findById(id);
        if (byId.isPresent()) {
            repository.delete(byId.get());
        } else throw new ResourceNotFoundException("Record not found with id" + byId.get().getId());
    }
}
