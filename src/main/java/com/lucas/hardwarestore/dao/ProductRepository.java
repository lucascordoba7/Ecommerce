package com.lucas.hardwarestore.dao;

import com.lucas.hardwarestore.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "productRepository")
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
