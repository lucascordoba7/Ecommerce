package com.lucas.hardwarestore.facade.mappers.product;

import com.lucas.hardwarestore.dto.product.ProductRequestData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.ProductModel;
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
