package com.lucas.hardwarestore.facade.mappers.user;

import com.lucas.hardwarestore.dto.user.RoleRequestData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.RoleModel;
import org.springframework.stereotype.Component;

@Component
public class RoleRequestMapper implements Mapper<RoleRequestData, RoleModel> {
    @Override
    public RoleModel mapFrom(final RoleRequestData source) {
        return RoleModel.builder()
                .name(source.getName())
                .build();
    }
}
