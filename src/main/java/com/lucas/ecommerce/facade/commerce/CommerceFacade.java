package com.lucas.ecommerce.facade.commerce;

public interface CommerceFacade {
    void addToCart(Long productId, Long quantity, boolean replaceQuantity);
}
