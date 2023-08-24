package com.lucas.ecommerce.facade.mappers.cart;

import com.lucas.ecommerce.dto.cart.CartEntryResponseData;
import com.lucas.ecommerce.dto.product.ProductResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.cart.CartEntryModel;
import com.lucas.ecommerce.model.product.ProductModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CartEntryResponseMapper implements Mapper<CartEntryModel, CartEntryResponseData> {
    @Resource
    private Mapper<ProductModel, ProductResponseData> productResponseMapper;

    @Override
    public CartEntryResponseData mapFrom(CartEntryModel source) {
        return CartEntryResponseData.builder()
                .id(source.getId())
                .quantity(source.getQuantity())
                .total(source.getTotal())
                .product(productResponseMapper.mapFrom(source.getProduct()))
                .build();
    }
}
