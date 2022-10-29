package com.lucas.hardwarestore.facade.user;

import com.lucas.hardwarestore.dto.user.RoleRequestData;
import com.lucas.hardwarestore.dto.user.RoleResponseData;
import com.lucas.hardwarestore.facade.AbstractFacadeBase;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.user.RoleModel;
import com.lucas.hardwarestore.service.GenericService;
import com.lucas.hardwarestore.service.user.RoleService;
import org.springframework.stereotype.Component;

@Component(value = "roleFacade")
public class RoleFacade extends AbstractFacadeBase<RoleRequestData, RoleResponseData, RoleModel> {
    private final RoleService roleService = (RoleService) getService();
    public RoleFacade(GenericService<RoleModel> service, Mapper<RoleRequestData, RoleModel> requestMapper, Mapper<RoleModel, RoleResponseData> responseMapper) {
        super(service, requestMapper, responseMapper);
    }
    public RoleResponseData findRoleByName(final String roleName){
        return getResponseMapper().mapFrom(roleService.findRoleByName(roleName));
    }
}
