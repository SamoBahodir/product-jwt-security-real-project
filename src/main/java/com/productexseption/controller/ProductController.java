package com.productexseption.controller;

import com.productexseption.exception.ResourceNotFoundException;
import com.productexseption.model.product.Product;
import com.productexseption.model.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getId/{id}")
    public Product getId(@PathVariable Long id) throws ResourceNotFoundException {
        return productService.getId(id);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) throws ResourceNotFoundException {
        productService.delete(id);
        return HttpStatus.OK;
    }
}
