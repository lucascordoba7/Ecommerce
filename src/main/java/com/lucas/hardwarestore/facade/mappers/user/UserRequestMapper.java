package com.lucas.hardwarestore.facade.mappers.user;

import com.lucas.hardwarestore.dto.user.UserRequestData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements Mapper<UserRequestData, UserModel> {
    @Override
    public UserModel mapFrom(final UserRequestData source) {
        return UserModel.builder()
                .username(source.getUsername())
                .password(source.getPassword())
                .email(source.getEmail())
                .phone(source.getPhone())
                .build();
    }
}
