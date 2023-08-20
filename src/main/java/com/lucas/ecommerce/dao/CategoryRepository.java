package com.lucas.ecommerce.dao;

import com.lucas.ecommerce.model.product.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "categoryRepository")
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
