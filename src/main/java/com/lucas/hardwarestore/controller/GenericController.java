package com.lucas.hardwarestore.controller;

import com.lucas.hardwarestore.facade.Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class GenericController<T, D> {
    private final Facade<T, D> facade;

    @GetMapping("")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(facade.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getOne(@PathVariable final Long id) {

        var response = facade.findById(id);
        if (response.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    ResponseEntity<?> create(@RequestBody final T t) {
        return ResponseEntity.ok(facade.create(t));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable final Long id) {
        facade.delete(id);
        return ResponseEntity.ok().build();
    }

    public Facade<T, D> getFacade() {
        return facade;
    }
}
