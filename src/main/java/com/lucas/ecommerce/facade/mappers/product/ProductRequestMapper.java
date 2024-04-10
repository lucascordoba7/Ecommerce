package com.lucas.ecommerce.facade.mappers.product;

import com.lucas.ecommerce.dto.product.ProductRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.ProductModel;
import com.lucas.ecommerce.service.product.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

@Component
public class ProductRequestMapper implements Mapper<ProductRequestData, ProductModel> {
    @Resource
    CategoryService categoryService;

    @Override
    public ProductModel mapFrom(ProductRequestData source) {
        final ProductModel product = ProductModel.builder().name(source.getName()).brand(source.getBrand()).price(source.getPrice()).build();

        if (!CollectionUtils.isEmpty(source.getCategories())) {
            product.setCategories(categoryService.getEntitiesByID(source.getCategories()));
        }
        return product;
    }
}
