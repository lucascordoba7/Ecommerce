package com.lucas.hardwarestore.facade.mappers.cart;

import com.lucas.hardwarestore.dto.cart.CartResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.facade.mappers.user.UserResponseMapper;
import com.lucas.hardwarestore.model.cart.CartModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CartResponseMapper implements Mapper<CartModel, CartResponseData> {
    @Resource
    private UserResponseMapper userResponseMapper;
    @Resource
    private CartEntryResponseMapper cartEntryResponseMapper;

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
