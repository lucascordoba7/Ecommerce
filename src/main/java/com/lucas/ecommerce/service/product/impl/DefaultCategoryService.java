package com.lucas.ecommerce.service.product.impl;

import com.lucas.ecommerce.dao.CategoryRepository;
import com.lucas.ecommerce.model.product.CategoryModel;
import com.lucas.ecommerce.service.product.CategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component(value = "categoryService")
public class DefaultCategoryService implements CategoryService {
    @Resource(name = "categoryRepository")
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryModel> findAll() {
        return getCategoryRepository().findAll();
    }

    @Override
    public Optional<CategoryModel> findById(long id) {
        return getCategoryRepository().findById(id);
    }

    @Override
    public CategoryModel create(CategoryModel model) {
        return getCategoryRepository().save(model);
    }


    @Override
    public void delete(long id) {
        getCategoryRepository().deleteById(id);
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
