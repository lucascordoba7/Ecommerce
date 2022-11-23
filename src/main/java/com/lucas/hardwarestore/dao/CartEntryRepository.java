package com.lucas.hardwarestore.dao;

import com.lucas.hardwarestore.model.cart.CartEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "cartEntryRepository")
public interface CartEntryRepository extends JpaRepository<CartEntryModel, Long> {
}
