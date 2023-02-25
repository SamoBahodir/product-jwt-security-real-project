package com.productexseption.model.product;

import com.productexseption.core.jpa_generic.JpaGenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaGenericRepository<Product> {
}
