package com.lucas.ecommerce.facade.mappers.user;

import com.lucas.ecommerce.dto.user.UserRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.user.UserModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRequestMapper implements Mapper<UserRequestData, UserModel> {
    @Resource
    private RoleRequestMapper roleRequestMapper;
    @Override
    public UserModel mapFrom(final UserRequestData source) {
        return UserModel.builder()
                .username(source.getUsername())
                .password(source.getPassword())
                .email(source.getEmail())
                .phone(source.getPhone())
                .roles(roleRequestMapper.mapAllFrom(source.getRoles()))
                .build();
    }
}
