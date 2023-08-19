package com.lucas.ecommerce.facade.mappers.cart;

import com.lucas.ecommerce.dto.cart.CartRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.cart.CartModel;
import org.springframework.stereotype.Component;

@Component
public class CartRequestMapper implements Mapper<CartRequestData, CartModel> {

    @Override
    public CartModel mapFrom(CartRequestData source) {
        return CartModel.builder()
                .build();
    }
}
