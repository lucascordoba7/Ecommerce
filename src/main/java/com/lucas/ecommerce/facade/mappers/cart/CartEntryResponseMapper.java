package com.lucas.ecommerce.facade.mappers.cart;

import com.lucas.ecommerce.dto.cart.CartEntryResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.facade.mappers.product.ProductResponseMapper;
import com.lucas.ecommerce.model.cart.CartEntryModel;
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
