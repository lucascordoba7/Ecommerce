package com.lucas.hardwarestore.facade.mappers.user;

import com.lucas.hardwarestore.dto.user.RoleResponseData;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.RoleModel;
import org.springframework.stereotype.Component;

@Component
public class RoleResponseMapper implements Mapper<RoleModel, RoleResponseData> {
    @Override
    public RoleResponseData mapFrom(final RoleModel source) {
        return RoleResponseData.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
