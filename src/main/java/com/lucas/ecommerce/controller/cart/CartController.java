package com.lucas.ecommerce.controller.cart;

import com.lucas.ecommerce.dto.cart.CartResponseData;
import com.lucas.ecommerce.facade.cart.CartFacade;
import com.lucas.ecommerce.facade.commerce.CommerceFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Tag(name = "Carts", description = "Cart controllers")
@RestController
@RequestMapping(value = "/api/cart")
public class CartController {
    @Resource
    private CartFacade cartFacade;
    @Resource
    private CommerceFacade commerceFacade;

    @Operation(summary = "Add to cart", description = "Adds or remove a specific amount of products")
    @PatchMapping("/addToCart")
    ResponseEntity<?> addToCart(@RequestParam final Long productId,
                                @RequestParam final Long quantity) {
        commerceFacade.addToCart(productId, quantity, false);
        return ResponseEntity.ok(cartFacade.getCurrentCart());
    }

    @Operation(summary = "Add to cart", description = "Sets the cart entry to the given quantity")
    @PutMapping("/addToCart")
    ResponseEntity<?> addToCartAndReplace(@RequestParam final Long productId,
                                          @RequestParam final Long quantity) {
        commerceFacade.addToCart(productId, quantity, true);
        return ResponseEntity.ok(cartFacade.getCurrentCart());
    }

    //GET
    @Operation(summary = "Get all the carts", description = "Retrieve a list of all carts.")
    @GetMapping("")
    ResponseEntity<List<CartResponseData>> getAll() {
        return ResponseEntity.ok(cartFacade.findAll());
    }


    @Operation(summary = "Get current cart", description = "Retrieve a list of all carts.")
    @GetMapping("/current")
    ResponseEntity<CartResponseData> getCurrentCart() {
        return ResponseEntity.ok(cartFacade.getCurrentCart());
    }

    //GET[id]
    @Operation(summary = "Get cart", description = "Gets a cart for a given id")
    @GetMapping("/{id}")
    ResponseEntity<CartResponseData> getOne(@PathVariable final Long id) {

        var response = cartFacade.findById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //DELETE
    @Operation(summary = "Delete cart", description = "Deletes a cart for a given id")
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable final Long id) {
        cartFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
