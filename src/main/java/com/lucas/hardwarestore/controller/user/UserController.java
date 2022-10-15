package com.lucas.hardwarestore.controller.user;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.dto.user.UserRequestData;
import com.lucas.hardwarestore.dto.user.UserResponseData;
import com.lucas.hardwarestore.facade.Facade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends GenericController<UserRequestData, UserResponseData> {
    public UserController(final Facade<UserRequestData, UserResponseData> userFacade) {
        super(userFacade);
    }
}
