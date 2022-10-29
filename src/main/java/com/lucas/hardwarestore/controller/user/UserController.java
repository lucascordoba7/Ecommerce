package com.lucas.hardwarestore.controller.user;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.dto.user.RoleRequestData;
import com.lucas.hardwarestore.dto.user.RoleToUserData;
import com.lucas.hardwarestore.dto.user.UserRequestData;
import com.lucas.hardwarestore.dto.user.UserResponseData;
import com.lucas.hardwarestore.facade.Facade;
import com.lucas.hardwarestore.facade.user.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends GenericController<UserRequestData, UserResponseData> {
    private final UserFacade userFacade = (UserFacade) getFacade();
    public UserController(final Facade<UserRequestData, UserResponseData> userFacade) {
        super(userFacade);
    }
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserResponseData> getUserByUsername(@PathVariable final String username){
        return ResponseEntity.ok(userFacade.findUserByUsername(username));
    }
    @PostMapping(value = "/addRole")
    public ResponseEntity<UserResponseData> addRoleToUser(@RequestBody final RoleToUserData form){
        userFacade.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok(userFacade.findUserByUsername(form.getUsername()));
    }
}
