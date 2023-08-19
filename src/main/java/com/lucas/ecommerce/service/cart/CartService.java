package com.lucas.ecommerce.service.cart;

import com.lucas.ecommerce.model.cart.CartModel;
import com.lucas.ecommerce.model.user.UserModel;
import com.lucas.ecommerce.service.GenericService;

import java.util.List;

public interface CartService extends GenericService<CartModel> {
    List<CartModel> getCartsForUser(UserModel user);
    CartModel save(CartModel cart);
}
