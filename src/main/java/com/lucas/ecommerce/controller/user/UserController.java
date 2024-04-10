package com.lucas.ecommerce.controller.user;

import com.lucas.ecommerce.dto.user.RoleToUserData;
import com.lucas.ecommerce.dto.user.UserRequestData;
import com.lucas.ecommerce.dto.user.UserResponseData;
import com.lucas.ecommerce.facade.user.UserFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Getter
@Tag(name = "Users", description = "User controllers")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserFacade userFacade;

    //GET
    @Operation(summary = "Get all the users", description = "Retrieve a list of all users.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserResponseData>> getAll() {
        return ResponseEntity.ok(getUserFacade().findAll());
    }

    //GET[id]
    @Operation(summary = "Get user", description = "Gets a user for a given id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseData> getOne(@PathVariable final Long id) {

        var response = getUserFacade().findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST
    @Operation(summary = "Create a new user", description = "Creates a new user from a ProductRequestData")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseData> create(@RequestBody UserRequestData userRequestData) {
        return ResponseEntity.ok(getUserFacade().create(userRequestData));
    }

    //DELETE
    @Operation(summary = "Delete user", description = "Deletes a user for a given id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable final Long id) {
        getUserFacade().delete(id);
    }

    //PUT
    @Operation(summary = "Updates user", description = "Updates an user for a given id")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponseData> update(@PathVariable final Long id, @RequestBody UserRequestData userRequestData) {
        return ResponseEntity.ok(getUserFacade().update(id, userRequestData));
    }

    @Operation(summary = "Find user by username", description = "Finds the user for a given username")
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserResponseData> getUserByUsername(@PathVariable final String username) {
        return ResponseEntity.ok(getUserFacade().findUserByUsername(username));
    }

    @Operation(summary = "Get current user", description = "Gets the current user")
    @GetMapping(value = "/current")
    public ResponseEntity<UserResponseData> getCurrrentUser() {
        return ResponseEntity.ok(getUserFacade().getCurrentUser());
    }

    @Operation(summary = "Add role", description = "Adds a existing role to a user")
    @PostMapping(value = "/addRole")
    public ResponseEntity<UserResponseData> addRoleToUser(@RequestBody final RoleToUserData form) {
        getUserFacade().addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok(getUserFacade().findUserByUsername(form.getUsername()));
    }
}
