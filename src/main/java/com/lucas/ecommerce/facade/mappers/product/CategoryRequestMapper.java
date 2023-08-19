package com.lucas.ecommerce.facade.mappers.product;

import com.lucas.ecommerce.dto.product.CategoryRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryRequestMapper implements Mapper<CategoryRequestData, CategoryModel> {
    @Override
    public CategoryModel mapFrom(CategoryRequestData source) {
        return CategoryModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
