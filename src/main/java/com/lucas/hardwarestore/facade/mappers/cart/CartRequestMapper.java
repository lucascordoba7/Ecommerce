package com.lucas.hardwarestore.facade.mappers.cart;

import com.lucas.hardwarestore.dto.cart.CartRequestData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.cart.CartModel;
import org.springframework.stereotype.Component;

@Component
public class CartRequestMapper implements Mapper<CartRequestData, CartModel> {

    @Override
    public CartModel mapFrom(CartRequestData source) {
        return CartModel.builder()
                .build();
    }
}
