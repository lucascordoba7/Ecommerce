package com.lucas.hardwarestore.facade;

import com.lucas.hardwarestore.dto.user.UserRequestData;
import com.lucas.hardwarestore.dto.user.UserResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.UserModel;
import com.lucas.hardwarestore.service.GenericService;
import org.springframework.stereotype.Component;

@Component
public class UserFacade extends AbstractFacadeBase<UserRequestData, UserResponseData, UserModel> {

    public UserFacade(final GenericService<UserModel> service,
                      final Mapper<UserRequestData, UserModel> requestMapper,
                      final Mapper<UserModel, UserResponseData> responseMapper) {
        super(service, requestMapper, responseMapper);
    }
}
