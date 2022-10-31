package com.lucas.hardwarestore.facade.mappers.user;

import com.lucas.hardwarestore.dto.user.UserResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.RoleModel;
import com.lucas.hardwarestore.model.user.UserModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserResponseMapper implements Mapper<UserModel, UserResponseData> {
    @Resource
    private RoleResponseMapper roleResponseMapper;
    @Override
    public UserResponseData mapFrom(final UserModel source) {
        return UserResponseData.builder()
                .id(source.getId())
                .username(source.getUsername())
                .email(source.getEmail())
                .phone(source.getPhone())
                .roles(roleResponseMapper.mapAllFrom((List<RoleModel>) source.getRoles()))
                .build();
    }
}
