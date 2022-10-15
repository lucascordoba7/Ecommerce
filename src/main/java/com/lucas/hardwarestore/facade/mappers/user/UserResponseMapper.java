package com.lucas.hardwarestore.facade.mappers.user;

import com.lucas.hardwarestore.dto.user.UserResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<UserModel, UserResponseData> {
    @Override
    public UserResponseData mapFrom(final UserModel source) {
        return UserResponseData.builder()
                .id(source.getId())
                .username(source.getUsername())
                .password(source.getPassword())
                .email(source.getEmail())
                .phone(source.getPhone())
                .build();
    }
}
