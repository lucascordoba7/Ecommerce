package com.lucas.ecommerce.facade.mappers.user;

import com.lucas.ecommerce.dto.user.RoleRequestData;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.user.RoleModel;
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
