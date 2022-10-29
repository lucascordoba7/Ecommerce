package com.lucas.hardwarestore.dao;

import com.lucas.hardwarestore.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(final String username);
}
