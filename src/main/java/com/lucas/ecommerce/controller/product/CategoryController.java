package com.lucas.ecommerce.controller.product;

import com.lucas.ecommerce.dto.product.CategoryRequestData;
import com.lucas.ecommerce.dto.product.CategoryResponseData;
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
@Tag(name = "Categories", description = "Category controllers")
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Resource
    private Facade<CategoryRequestData, CategoryResponseData> facade;

    //GET
    @Operation(summary = "Get all the categories", description = "Retrieve a list of all categories.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryResponseData>> getAll() {
        return ResponseEntity.ok(getFacade().findAll());
    }

    //GET[id]
    @Operation(summary = "Get category", description = "Gets a category from an id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryResponseData> getOne(@PathVariable final Long id) {

        var response = getFacade().findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST
    @Operation(summary = "Create a new category", description = "Creates a new category from a CategoryRequestData")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponseData> create(@RequestBody CategoryRequestData categoryRequestData) {
        return ResponseEntity.ok(getFacade().create(categoryRequestData));
    }

    //DELETE
    @Operation(summary = "Delete category", description = "Deletes a category for a given id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable final Long id) {
        getFacade().delete(id);
    }

}
