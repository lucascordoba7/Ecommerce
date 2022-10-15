package com.lucas.hardwarestore.facade.mappers.product;

import com.lucas.hardwarestore.dto.product.ProductResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.product.ProductModel;
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
