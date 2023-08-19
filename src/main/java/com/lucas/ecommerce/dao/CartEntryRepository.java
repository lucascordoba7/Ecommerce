package com.lucas.ecommerce.dao;

import com.lucas.ecommerce.model.cart.CartEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "cartEntryRepository")
public interface CartEntryRepository extends JpaRepository<CartEntryModel, Long> {
    Optional<CartEntryModel> findByProduct_Id(Long id);
}
