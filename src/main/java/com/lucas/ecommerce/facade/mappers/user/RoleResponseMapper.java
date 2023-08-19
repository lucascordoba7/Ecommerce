package com.lucas.ecommerce.facade.mappers.user;

import com.lucas.ecommerce.dto.user.RoleResponseData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.user.RoleModel;
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
