package com.lucas.ecommerce.controller.user;

import com.lucas.ecommerce.controller.GenericController;
import com.lucas.ecommerce.dto.user.RoleRequestData;
import com.lucas.ecommerce.dto.user.RoleResponseData;
import com.lucas.ecommerce.facade.Facade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Roles", description = "Role controllers")
@RestController
@RequestMapping(value = "/api/role")
public class RoleController extends GenericController<RoleRequestData, RoleResponseData> {
    public RoleController(Facade<RoleRequestData, RoleResponseData> facade) {
        super(facade);
    }
}
