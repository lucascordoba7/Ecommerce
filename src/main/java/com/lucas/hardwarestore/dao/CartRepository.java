package com.lucas.hardwarestore.dao;

import com.lucas.hardwarestore.model.cart.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "cartRepository")
public interface CartRepository extends JpaRepository<CartModel, Long> {
}
