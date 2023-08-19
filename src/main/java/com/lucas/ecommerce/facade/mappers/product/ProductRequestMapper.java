package com.lucas.ecommerce.facade.mappers.product;

import com.lucas.ecommerce.dto.product.ProductRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper implements Mapper<ProductRequestData, ProductModel> {
    @Override
    public ProductModel mapFrom(ProductRequestData source) {
        return ProductModel.builder()
                .name(source.getName())
                .brand(source.getBrand())
                .price(source.getPrice())
                .build();
    }
}
