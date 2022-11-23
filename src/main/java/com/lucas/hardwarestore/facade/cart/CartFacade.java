package com.lucas.hardwarestore.facade.cart;

import com.lucas.hardwarestore.dto.cart.CartRequestData;
import com.lucas.hardwarestore.dto.cart.CartResponseData;
import com.lucas.hardwarestore.facade.AbstractFacadeBase;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.cart.CartModel;
import com.lucas.hardwarestore.service.GenericService;
import org.springframework.stereotype.Component;

@Component(value = "cartFacade")
public class CartFacade extends AbstractFacadeBase<CartRequestData, CartResponseData, CartModel> {

    public CartFacade(GenericService<CartModel> service, Mapper<CartRequestData, CartModel> requestMapper, Mapper<CartModel, CartResponseData> responseMapper) {
        super(service, requestMapper, responseMapper);
    }
}
