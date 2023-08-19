package com.lucas.ecommerce.controller.cart;

import com.lucas.ecommerce.facade.cart.CartFacade;
import com.lucas.ecommerce.facade.commerce.CommerceFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "Carts", description = "Cart controllers")
@RestController
@RequestMapping(value = "/api/cart")
public class CartController {
    @Resource
    private CartFacade cartFacade;
    @Resource
    private CommerceFacade commerceFacade;

    @PatchMapping("/addToCart")
    ResponseEntity<?> addToCart(@RequestParam final Long productId,
                                @RequestParam final Long quantity){
        commerceFacade.addToCart(productId, quantity, false);
        return ResponseEntity.ok(cartFacade.getCurrentCart());
    }
    @PutMapping("/addToCart")
    ResponseEntity<?> addToCartAndReplace(@RequestParam final Long productId,
                                @RequestParam final Long quantity){
        commerceFacade.addToCart(productId, quantity, true);
        return ResponseEntity.ok(cartFacade.getCurrentCart());
    }
    @GetMapping("")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(cartFacade.findAll());
    }
    @GetMapping("/current")
    ResponseEntity<?> getCurrentCart() {
        return ResponseEntity.ok(cartFacade.getCurrentCart());
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
