package com.lucas.ecommerce.dao;

import com.lucas.ecommerce.model.cart.CartModel;
import com.lucas.ecommerce.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "cartRepository")
public interface CartRepository extends JpaRepository<CartModel, Long> {
    List<CartModel> findByUser(UserModel user);
}
