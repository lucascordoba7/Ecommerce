package com.lucas.ecommerce.facade.mappers.user;

import com.lucas.ecommerce.dto.user.UserResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.user.RoleModel;
import com.lucas.ecommerce.model.user.UserModel;
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
