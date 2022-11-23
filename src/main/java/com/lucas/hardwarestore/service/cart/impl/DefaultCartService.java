package com.lucas.hardwarestore.service.cart.impl;

import com.lucas.hardwarestore.dao.CartRepository;
import com.lucas.hardwarestore.model.cart.CartModel;
import com.lucas.hardwarestore.service.cart.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "cartService")
public class DefaultCartService implements CartService {

    @Resource(name = "cartRepository")
    private CartRepository cartRepository;

    @Override
    public List<CartModel> findAll() {
        return getCartRepository().findAll();
    }

    @Override
    public Optional<CartModel> findById(long id) {
        return getCartRepository().findById(id);
    }

    @Override
    public CartModel create(CartModel model) {
        return getCartRepository().save(model);
    }

    @Override
    public void delete(long id) {
        getCartRepository().deleteById(id);
    }

    public CartRepository getCartRepository() {
        return cartRepository;
    }

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
