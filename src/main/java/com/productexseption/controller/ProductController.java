package com.productexseption.controller;

import com.productexseption.core.SuccessDataIterable;
import com.productexseption.core.SuccessfulResponse;
import com.productexseption.core.page_request.PageableRequest;
import com.productexseption.exception.ResourceNotFoundException;
import com.productexseption.model.product.Product;
import com.productexseption.model.product.ProductResponse;
import com.productexseption.model.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getId/{id}")
    public SuccessfulResponse<ProductResponse> getId(@PathVariable Long id) throws ResourceNotFoundException {
        return new SuccessfulResponse<>(new ProductResponse(productService.getId(id)),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public SuccessfulResponse<List<ProductResponse>> getAll() {
        return new SuccessfulResponse<>(productService.getAll());
    }

    @PostMapping("/create")
    public SuccessfulResponse<ProductResponse> create(@RequestBody Product product) {
        return new SuccessfulResponse<>(new ProductResponse(productService.create(product)),HttpStatus.OK);
    }

    @PostMapping("/monitoring")
    public SuccessDataIterable<ProductResponse> monitoring(@RequestBody PageableRequest pageRequest) {
        return new SuccessDataIterable<>(productService.monitoring(pageRequest).map(ProductResponse::new));
    }

    @PutMapping("/update/{id}")
    public SuccessfulResponse<ProductResponse> update(@PathVariable Long id, @RequestBody Product product) throws ResourceNotFoundException {
        return new SuccessfulResponse<>(new ProductResponse(productService.update(id, product)),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public SuccessfulResponse<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        productService.delete(id);
        return new SuccessfulResponse<>(HttpStatus.OK);
    }
}
