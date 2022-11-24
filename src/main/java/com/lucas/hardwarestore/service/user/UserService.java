package com.lucas.hardwarestore.service.user;

import com.lucas.hardwarestore.model.user.UserModel;
import com.lucas.hardwarestore.service.GenericService;

public interface UserService extends GenericService<UserModel> {
    void addRoleToUser(final String username, final String roleName);
    UserModel getUserByUsername(final String username);
    UserModel getCurrentUser();
}
