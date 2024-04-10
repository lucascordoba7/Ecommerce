package com.lucas.ecommerce.facade.cart;

import com.lucas.ecommerce.dto.cart.CartRequestData;
import com.lucas.ecommerce.dto.cart.CartResponseData;
import com.lucas.ecommerce.facade.AbstractFacadeBase;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.cart.CartModel;
import com.lucas.ecommerce.service.GenericService;
import com.lucas.ecommerce.service.commerce.CommerceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "cartFacade")
public class CartFacade extends AbstractFacadeBase<CartRequestData, CartResponseData, CartModel> {
    @Resource(name = "commerceService")
    private CommerceService commerceService;

    public CartFacade(GenericService<CartModel> service, Mapper<CartRequestData, CartModel> requestMapper, Mapper<CartModel, CartResponseData> responseMapper) {
        super(service, requestMapper, responseMapper);
    }

    public CartResponseData getCurrentCart() {
        return getResponseMapper().mapFrom(commerceService.getCurrentCart());
    }

    @Override
    protected void setId(CartModel cartModel, long id) {
        cartModel.setId(id);
    }
}
