package com.lucas.hardwarestore.facade.mappers.cart;

import com.lucas.hardwarestore.dto.cart.CartEntryResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.facade.mappers.product.ProductResponseMapper;
import com.lucas.hardwarestore.model.cart.CartEntryModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CartEntryResponseMapper implements Mapper<CartEntryModel, CartEntryResponseData> {
    @Resource
    private ProductResponseMapper productResponseMapper;

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
