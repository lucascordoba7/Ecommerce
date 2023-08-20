package com.lucas.ecommerce.facade.mappers.product;

import com.lucas.ecommerce.dto.product.CategoryResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseMapper implements Mapper<CategoryModel, CategoryResponseData> {
    @Override
    public CategoryResponseData mapFrom(CategoryModel source) {
        return CategoryResponseData.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
