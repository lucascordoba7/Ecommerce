package com.lucas.ecommerce.service.commerce;

import com.lucas.ecommerce.model.cart.CartModel;

public interface CommerceService {
    void addToCart(Long productId, Long quantity, boolean replaceQuantity);

    CartModel getCurrentCart();
}
