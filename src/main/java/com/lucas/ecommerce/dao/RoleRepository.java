package com.lucas.ecommerce.dao;

import com.lucas.ecommerce.model.user.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "roleRepository")
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(String name);
}
