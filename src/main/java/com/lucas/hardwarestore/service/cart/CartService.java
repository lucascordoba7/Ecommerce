package com.lucas.hardwarestore.service.cart;

import com.lucas.hardwarestore.model.cart.CartModel;
import com.lucas.hardwarestore.model.user.UserModel;
import com.lucas.hardwarestore.service.GenericService;

import java.util.List;

public interface CartService extends GenericService<CartModel> {
    List<CartModel> getCartsForUser(UserModel user);
    CartModel save(CartModel cart);
}
