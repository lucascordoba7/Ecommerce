package com.lucas.hardwarestore.controller.cart;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.dto.cart.CartRequestData;
import com.lucas.hardwarestore.dto.cart.CartResponseData;
import com.lucas.hardwarestore.facade.Facade;
import com.lucas.hardwarestore.facade.cart.CartFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/cart")
public class CartController {
    @Resource
    private CartFacade cartFacade;

    @GetMapping("")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(cartFacade.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getOne(@PathVariable final Long id) {

        var response = cartFacade.findById(id);
        if (response.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable final Long id) {
        cartFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
