package com.lucas.hardwarestore.facade.mappers.cart;

import com.lucas.hardwarestore.dto.cart.CartEntryRequestData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.cart.CartEntryModel;
import org.springframework.stereotype.Component;

@Component
public class CartEntryRequestMapper implements Mapper<CartEntryRequestData, CartEntryModel> {
    @Override
    public CartEntryModel mapFrom(CartEntryRequestData source) {
        return CartEntryModel.builder().build();
    }
}
