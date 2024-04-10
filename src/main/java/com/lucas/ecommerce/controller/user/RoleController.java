package com.lucas.ecommerce.controller.user;

import com.lucas.ecommerce.dto.user.RoleRequestData;
import com.lucas.ecommerce.dto.user.RoleResponseData;
import com.lucas.ecommerce.facade.Facade;
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
@Tag(name = "Roles", description = "Role controllers")
@RestController
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
    @Operation(summary = "Delete role", description = "Deletes a role for a given id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable final Long id) {
        getFacade().delete(id);
    }

    //PUT
    @Operation(summary = "Updates role", description = "Updates a role for a given id")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RoleResponseData> update(@PathVariable final Long id, @RequestBody RoleRequestData roleRequestData) {
        return ResponseEntity.ok(getFacade().update(id, roleRequestData));
    }

    public void setFacade(Facade<RoleRequestData, RoleResponseData> facade) {
        this.facade = facade;
    }
}
