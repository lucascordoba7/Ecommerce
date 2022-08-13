package com.lucas.hardwarestore.controller;

import com.lucas.hardwarestore.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<T> {

    final private GenericService<T> genericService;

    public GenericController(final GenericService<T> genericService) {
        this.genericService = genericService;
    }

    @GetMapping("")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(genericService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getOne(@PathVariable final Long id) {
        return ResponseEntity.ok(genericService.findById(id));
    }

    @PostMapping("")
    ResponseEntity<?> create(@RequestBody final T t) {
        return ResponseEntity.ok(genericService.create(t));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable final Long id) {
        genericService.delete(id);
        return ResponseEntity.ok().build();
    }
}
