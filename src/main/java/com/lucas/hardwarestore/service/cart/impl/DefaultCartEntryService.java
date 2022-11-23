package com.lucas.hardwarestore.service.cart.impl;

import com.lucas.hardwarestore.dao.CartEntryRepository;
import com.lucas.hardwarestore.model.cart.CartEntryModel;
import com.lucas.hardwarestore.service.cart.CartEntryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "cartEntryService")
public class DefaultCartEntryService implements CartEntryService {

    @Resource(name = "cartEntryRepository")
    private CartEntryRepository cartEntryRepository;

    @Override
    public List<CartEntryModel> findAll() {
        return getCartEntryRepository().findAll();
    }

    @Override
    public Optional<CartEntryModel> findById(long id) {
        return getCartEntryRepository().findById(id);
    }

    @Override
    public CartEntryModel create(CartEntryModel model) {
        return getCartEntryRepository().save(model);
    }

    @Override
    public void delete(long id) {
        getCartEntryRepository().deleteById(id);
    }

    public CartEntryRepository getCartEntryRepository() {
        return cartEntryRepository;
    }

    public void setCartEntryRepository(CartEntryRepository cartEntryRepository) {
        this.cartEntryRepository = cartEntryRepository;
    }
}
