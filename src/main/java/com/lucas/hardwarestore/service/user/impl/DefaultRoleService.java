package com.lucas.hardwarestore.service.user.impl;

import com.lucas.hardwarestore.dao.RoleRepository;
import com.lucas.hardwarestore.model.user.RoleModel;
import com.lucas.hardwarestore.service.user.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "roleService")
public class DefaultRoleService implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Override
    public List<RoleModel> findAll() {
        return getRoleRepository().findAll();
    }

    @Override
    public Optional<RoleModel> findById(final long id) {
        return getRoleRepository().findById(id);
    }

    @Override
    public RoleModel create(final RoleModel model) {
        return getRoleRepository().save(model);
    }

    @Override
    public void delete(final long id) {
        getRoleRepository().deleteById(id);
    }

    @Override
    public RoleModel findRoleByName(String roleName) {
        return getRoleRepository().findByName(roleName).orElse(null);
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
