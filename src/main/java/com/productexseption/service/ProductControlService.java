package com.productexseption.service;

import com.productexseption.domen.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductControlService {

    public static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product olma = new Product();
        olma.setId("1");
        olma.setName("Olma");
        productRepo.put(olma.getId(), olma);

        Product limon = new Product();
        limon.setId("2");
        limon.setName("Limon");
        productRepo.put(limon.getId(), limon);

    }

    @PutMapping("/product/{id}")
    public ResponseEntity updatePro(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity("Product is updated successfully", HttpStatus.OK);

    }
    @GetMapping("/product")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(productRepo.values());
    }

}
