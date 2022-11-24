package com.lucas.hardwarestore.service.commerce.impl;

import com.lucas.hardwarestore.model.cart.CartEntryModel;
import com.lucas.hardwarestore.model.cart.CartModel;
import com.lucas.hardwarestore.model.product.ProductModel;
import com.lucas.hardwarestore.model.user.UserModel;
import com.lucas.hardwarestore.service.cart.CartEntryService;
import com.lucas.hardwarestore.service.cart.CartService;
import com.lucas.hardwarestore.service.commerce.CommerceService;
import com.lucas.hardwarestore.service.product.ProductService;
import com.lucas.hardwarestore.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service(value = "commerceService")
public class DefaultCommerceService implements CommerceService {
    @Resource
    private UserService userService;
    @Resource
    private CartService cartService;
    @Resource
    private CartEntryService cartEntryService;
    @Resource
    private ProductService productService;

    @Override
    public void addToCart(final Long productId, final Long quantity) {
        final CartModel cart = getCurrentCart();
        final Optional<CartEntryModel> existingEntry = cart.getEntries().stream()
                .filter(e -> e.getProduct().getId().equals(productId))
                .findAny();

        CartEntryModel entry;

        if (existingEntry.isPresent()) {
            entry = existingEntry.get();
            entry.setQuantity(entry.getQuantity() + quantity);
        } else {
            entry = new CartEntryModel();
            final ProductModel product = productService.findById(productId).orElseThrow(IllegalStateException::new);
            entry.setQuantity(quantity);
            entry.setProduct(product);
            entry.setOrder(cart);
            entry.setTotal(BigDecimal.ZERO);

            if (cart.getEntries() != null) {
                cart.getEntries().add(entry);
            } else {
                final List<CartEntryModel> entries = new ArrayList<>();
                entries.add(entry);
                cart.setEntries(entries);
            }
        }
        cartEntryService.save(entry);
        cartService.save(cart);
    }

    @Override
    public CartModel getCurrentCart() {
        final UserModel currentUser = userService.getCurrentUser();
        final List<CartModel> carts = cartService.getCartsForUser(currentUser);
        final Optional<CartModel> lastModified = carts.stream().min(Comparator.comparing(c -> c.getModified().compareTo(new Date())));
        if (lastModified.isEmpty()) {
            return cartService.create(new CartModel());
        }
        return lastModified.get();
    }
}
