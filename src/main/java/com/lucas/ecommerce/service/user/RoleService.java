package com.lucas.ecommerce.service.user;

import com.lucas.ecommerce.model.user.RoleModel;
import com.lucas.ecommerce.service.GenericService;

public interface RoleService extends GenericService<RoleModel> {
    RoleModel findRoleByName(final String roleName);
}
