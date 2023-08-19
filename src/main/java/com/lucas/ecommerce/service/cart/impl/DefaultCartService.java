package com.lucas.ecommerce.service.cart.impl;

import com.lucas.ecommerce.dao.CartRepository;
import com.lucas.ecommerce.model.cart.CartModel;
import com.lucas.ecommerce.model.user.UserModel;
import com.lucas.ecommerce.service.cart.CartService;
import com.lucas.ecommerce.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service(value = "cartService")
public class DefaultCartService implements CartService {

    @Resource(name = "cartRepository")
    private CartRepository cartRepository;
    @Resource(name = "userService")
    private UserService userService;

    @Override
    public List<CartModel> getCartsForUser(final UserModel user) {
        return cartRepository.findByUser(user);
    }

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
        final UserModel current = userService.getCurrentUser();
        model.setUser(current);
        model.setModified(new Date());
        model.setCreated(new Date());
        model.setStatus("CREATED");
        model.setSubtotal(BigDecimal.ZERO);
        model.setTotal(BigDecimal.ZERO);
        model.setEntries(new ArrayList<>());
        return getCartRepository().save(model);
    }

    @Override
    public CartModel save(CartModel model) {
        model.setModified(new Date());
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
