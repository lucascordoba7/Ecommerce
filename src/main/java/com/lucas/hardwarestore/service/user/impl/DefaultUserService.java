package com.lucas.hardwarestore.service.user.impl;

import com.lucas.hardwarestore.dao.RoleRepository;
import com.lucas.hardwarestore.dao.UserRepository;
import com.lucas.hardwarestore.model.user.RoleModel;
import com.lucas.hardwarestore.model.user.UserModel;
import com.lucas.hardwarestore.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "userService")
@Transactional
@Slf4j
public class DefaultUserService implements UserService, UserDetailsService {
    @Resource(name = "userRepository")
    private UserRepository userRepository;
    @Resource(name = "roleRepository")
    private RoleRepository roleRepository;
    @Resource(name = "bCryptPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> findAll() {
        return getUserRepository().findAll();
    }

    @Override
    public Optional<UserModel> findById(long id) {
        return getUserRepository().findById(id);
    }

    @Override
    public UserModel create(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        if (userModel.getRoles() != null) {
            userModel.setRoles(
                    userModel.getRoles().stream()
                            .map(r -> roleRepository.findByName(r.getName()).orElse(null))
                            .filter(Objects::nonNull)
                            .collect(Collectors.toSet()));
        }
        return getUserRepository().save(userModel);
    }

    @Override
    public void delete(long id) {
        getUserRepository().deleteById(id);
    }


    @Override
    public void addRoleToUser(final String username, final String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        final UserModel user = getUserByUsername(username);
        final Optional<RoleModel> role = getRoleRepository().findByName(roleName);
        role.ifPresent(r -> user.getRoles().add(r));
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return getUserRepository().findByUsername(username).orElse(null);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserModel userModel = getUserByUsername(username);
        if (userModel == null) {
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        final List<SimpleGrantedAuthority> authorities = userModel.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();

        return new org.springframework.security.core.userdetails.User(userModel.getUsername(), userModel.getPassword(), authorities);
    }
}
