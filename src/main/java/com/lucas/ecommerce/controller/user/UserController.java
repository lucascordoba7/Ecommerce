package com.lucas.ecommerce.controller.user;

import com.lucas.ecommerce.controller.GenericController;
import com.lucas.ecommerce.dto.user.RoleToUserData;
import com.lucas.ecommerce.dto.user.UserRequestData;
import com.lucas.ecommerce.dto.user.UserResponseData;
import com.lucas.ecommerce.facade.Facade;
import com.lucas.ecommerce.facade.user.UserFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users", description = "User controllers")
@RestController
@RequestMapping(value = "/api/user")
public class UserController extends GenericController<UserRequestData, UserResponseData> {
    private final UserFacade userFacade = (UserFacade) getFacade();

    public UserController(final Facade<UserRequestData, UserResponseData> userFacade) {
        super(userFacade);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserResponseData> getUserByUsername(@PathVariable final String username) {
        return ResponseEntity.ok(userFacade.findUserByUsername(username));
    }

    @GetMapping(value = "/current")
    public ResponseEntity<UserResponseData> getCurrrentUser() {
        return ResponseEntity.ok(userFacade.getCurrentUser());
    }

    @PostMapping(value = "/addRole")
    public ResponseEntity<UserResponseData> addRoleToUser(@RequestBody final RoleToUserData form) {
        userFacade.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok(userFacade.findUserByUsername(form.getUsername()));
    }
}
