package com.lucas.ecommerce.facade.mappers.cart;

import com.lucas.ecommerce.dto.cart.CartEntryResponseData;
import com.lucas.ecommerce.dto.cart.CartResponseData;
import com.lucas.ecommerce.dto.user.UserResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.cart.CartEntryModel;
import com.lucas.ecommerce.model.cart.CartModel;
import com.lucas.ecommerce.model.user.UserModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CartResponseMapper implements Mapper<CartModel, CartResponseData> {
    @Resource
    private Mapper<UserModel, UserResponseData> userResponseMapper;
    @Resource
    private Mapper<CartEntryModel, CartEntryResponseData> cartEntryResponseMapper;

    @Override
    public CartResponseData mapFrom(CartModel source) {
        return CartResponseData.builder()
                .id(source.getId())
                .created(source.getCreated())
                .modified(source.getModified())
                .status(source.getStatus())
                .subtotal(source.getSubtotal())
                .total(source.getTotal())
                .user(userResponseMapper.mapFrom(source.getUser()))
                .entries(cartEntryResponseMapper.mapAllFrom(source.getEntries()))
                .build();
    }
}
