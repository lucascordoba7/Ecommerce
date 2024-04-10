package com.lucas.ecommerce.facade.user;

import com.lucas.ecommerce.dto.user.RoleRequestData;
import com.lucas.ecommerce.dto.user.RoleResponseData;
import com.lucas.ecommerce.facade.AbstractFacadeBase;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.user.RoleModel;
import com.lucas.ecommerce.service.GenericService;
import com.lucas.ecommerce.service.user.RoleService;
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

    @Override
    protected void setId(RoleModel roleModel, long id) {
        roleModel.setId(id);
    }
}
