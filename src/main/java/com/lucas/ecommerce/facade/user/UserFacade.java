package com.lucas.ecommerce.facade.user;

import com.lucas.ecommerce.dto.user.UserRequestData;
import com.lucas.ecommerce.dto.user.UserResponseData;
import com.lucas.ecommerce.facade.AbstractFacadeBase;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.user.UserModel;
import com.lucas.ecommerce.service.GenericService;
import com.lucas.ecommerce.service.user.UserService;
import org.springframework.stereotype.Component;

@Component(value = "userFacade")
public class UserFacade extends AbstractFacadeBase<UserRequestData, UserResponseData, UserModel> {

    private final UserService userService = (UserService) getService();
    public UserFacade(final GenericService<UserModel> service,
                      final Mapper<UserRequestData, UserModel> requestMapper,
                      final Mapper<UserModel, UserResponseData> responseMapper) {
        super(service, requestMapper, responseMapper);
    }

    public UserResponseData findUserByUsername(final String username) {
        return getResponseMapper().mapFrom(userService.getUserByUsername(username));
    }
    public UserResponseData getCurrentUser(){
        return getResponseMapper().mapFrom(userService.getCurrentUser());
    }

    public void addRoleToUser(final String username, final String roleName){
        userService.addRoleToUser(username, roleName);
    }

    @Override
    protected void setId(UserModel userModel, long id) {
        userModel.setId(id);
    }
}
