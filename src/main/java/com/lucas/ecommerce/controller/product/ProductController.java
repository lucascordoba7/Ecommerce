package com.lucas.ecommerce.controller.product;

import com.lucas.ecommerce.dto.product.ProductRequestData;
import com.lucas.ecommerce.dto.product.ProductResponseData;
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
@Tag(name = "Products", description = "Product controllers")
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Resource
    private Facade<ProductRequestData, ProductResponseData> facade;

    //GET
    @Operation(summary = "Get all the products", description = "Retrieve a list of all products.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductResponseData>> getAll() {
        return ResponseEntity.ok(getFacade().findAll());
    }

    //GET[id]
    @Operation(summary = "Get product", description = "Gets a product for a given id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponseData> getOne(@PathVariable final Long id) {

        var response = getFacade().findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST
    @Operation(summary = "Create a new product", description = "Creates a new product from a ProductRequestData")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseData> create(@RequestBody ProductRequestData productRequestData) {
        return ResponseEntity.ok(getFacade().create(productRequestData));
    }

    //DELETE
    @Operation(summary = "Delete product", description = "Deletes a product for a given id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable final Long id) {
        getFacade().delete(id);
    }

    //PUT
    @Operation(summary = "Updates product", description = "Updates a product for a given id")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponseData> update(@PathVariable final Long id, @RequestBody ProductRequestData productRequestData) {
        return ResponseEntity.ok(getFacade().update(id, productRequestData));
    }

    public void setFacade(Facade<ProductRequestData, ProductResponseData> facade) {
        this.facade = facade;
    }
}
