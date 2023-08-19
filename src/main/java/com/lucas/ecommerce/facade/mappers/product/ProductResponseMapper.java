package com.lucas.ecommerce.facade.mappers.product;

import com.lucas.ecommerce.dto.product.ProductResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper implements Mapper<ProductModel, ProductResponseData> {
    @Override
    public ProductResponseData mapFrom(ProductModel source) {
        return ProductResponseData.builder()
                .id(source.getId())
                .name(source.getName())
                .brand(source.getBrand())
                .price(source.getPrice())
                .build();
    }
}
