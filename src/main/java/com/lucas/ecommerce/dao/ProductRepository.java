package com.lucas.ecommerce.dao;

import com.lucas.ecommerce.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "productRepository")
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
