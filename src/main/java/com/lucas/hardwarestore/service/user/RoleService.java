package com.lucas.hardwarestore.service.user;

import com.lucas.hardwarestore.model.user.RoleModel;
import com.lucas.hardwarestore.service.GenericService;

public interface RoleService extends GenericService<RoleModel> {
    RoleModel findRoleByName(final String roleName);
}
