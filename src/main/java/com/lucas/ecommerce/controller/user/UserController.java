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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.List;

@Getter
@Tag(name = "Users", description = "User controllers")
@RestControllerAdvice
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserFacade userFacade;

    //GET
    @Operation(summary = "Get all the products", description = "Retrieve a list of all products.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserResponseData>> getAll() {
        return ResponseEntity.ok(getUserFacade().findAll());
    }

    //GET[id]
    @Operation(summary = "Get product", description = "Gets a product for a given id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseData> getOne(@PathVariable final Long id) {

        var response = getUserFacade().findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST
    @Operation(summary = "Create a new product", description = "Creates a new product from a ProductRequestData")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseData> create(@RequestBody UserRequestData userRequestData) {
        return ResponseEntity.ok(getUserFacade().create(userRequestData));
    }

    //DELETE
    @Operation(summary = "Delete category", description = "Deletes a product for a given id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable final Long id) {
        getUserFacade().delete(id);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserResponseData> getUserByUsername(@PathVariable final String username) {
        return ResponseEntity.ok(getUserFacade().findUserByUsername(username));
    }

    @GetMapping(value = "/current")
    public ResponseEntity<UserResponseData> getCurrrentUser() {
        return ResponseEntity.ok(getUserFacade().getCurrentUser());
    }

    @PostMapping(value = "/addRole")
    public ResponseEntity<UserResponseData> addRoleToUser(@RequestBody final RoleToUserData form) {
        getUserFacade().addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok(getUserFacade().findUserByUsername(form.getUsername()));
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
