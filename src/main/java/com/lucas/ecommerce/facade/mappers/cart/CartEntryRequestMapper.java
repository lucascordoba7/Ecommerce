package com.lucas.ecommerce.facade.mappers.cart;

import com.lucas.ecommerce.dto.cart.CartEntryRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.cart.CartEntryModel;
import org.springframework.stereotype.Component;

@Component
public class CartEntryRequestMapper implements Mapper<CartEntryRequestData, CartEntryModel> {
    @Override
    public CartEntryModel mapFrom(CartEntryRequestData source) {
        return CartEntryModel.builder().build();
    }
}
