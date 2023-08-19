package com.lucas.ecommerce.controller.user;

import com.lucas.ecommerce.dto.user.RoleRequestData;
import com.lucas.ecommerce.dto.user.RoleResponseData;
import com.lucas.ecommerce.facade.Facade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Roles", description = "Role controllers")
@RestControllerAdvice
@RequestMapping(value = "/api/role")
public class RoleController {
    @Resource
    private Facade<RoleRequestData, RoleResponseData> facade;

    //GET
    @Operation(summary = "Get all the roles", description = "Retrieve a list of all roles.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<RoleResponseData>> getAll() {
        return ResponseEntity.ok(getFacade().findAll());
    }

    //GET[id]
    @Operation(summary = "Get role", description = "Gets a role for a given id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RoleResponseData> getOne(@PathVariable final Long id) {

        var response = getFacade().findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST
    @Operation(summary = "Create a new role", description = "Creates a new role from a RoleRequestData")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseData> create(@RequestBody RoleRequestData roleRequestData) {
        return ResponseEntity.ok(getFacade().create(roleRequestData));
    }

    //DELETE
    @Operation(summary = "Delete category", description = "Deletes a role for a given id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable final Long id) {
        getFacade().delete(id);
    }

    public Facade<RoleRequestData, RoleResponseData> getFacade() {
        return facade;
    }

    public void setFacade(Facade<RoleRequestData, RoleResponseData> facade) {
        this.facade = facade;
    }
}
