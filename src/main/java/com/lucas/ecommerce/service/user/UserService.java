package com.lucas.ecommerce.service.user;

import com.lucas.ecommerce.model.user.UserModel;
import com.lucas.ecommerce.service.GenericService;

public interface UserService extends GenericService<UserModel> {
    void addRoleToUser(final String username, final String roleName);
    UserModel getUserByUsername(final String username);
    UserModel getCurrentUser();
}
