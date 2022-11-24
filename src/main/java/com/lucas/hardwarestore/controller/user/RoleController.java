package com.lucas.hardwarestore.controller.user;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.dto.user.RoleRequestData;
import com.lucas.hardwarestore.dto.user.RoleResponseData;
import com.lucas.hardwarestore.facade.Facade;
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
