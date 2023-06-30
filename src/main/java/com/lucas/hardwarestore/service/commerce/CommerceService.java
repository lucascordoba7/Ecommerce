package com.lucas.hardwarestore.service.commerce;

import com.lucas.hardwarestore.model.cart.CartModel;

public interface CommerceService {
    void addToCart(Long productId, Long quantity, boolean replaceQuantity);

    CartModel getCurrentCart();
}
