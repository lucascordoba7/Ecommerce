package com.lucas.hardwarestore.service.calculation.impl;

import com.lucas.hardwarestore.model.cart.CartEntryModel;
import com.lucas.hardwarestore.model.cart.CartModel;
import com.lucas.hardwarestore.service.calculation.CalculationService;
import com.lucas.hardwarestore.service.cart.CartEntryService;
import com.lucas.hardwarestore.service.cart.CartService;
import com.lucas.hardwarestore.service.commerce.CommerceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component(value = "calculationService")
public class DefaultCalculationService implements CalculationService {

    @Resource(name = "commerceService")
    private CommerceService commerceService;
    @Resource(name = "cartEntryService")
    private CartEntryService cartEntryService;
    @Resource(name = "cartService")
    private CartService cartService;

    @Override
    public void recalculate() {
        final CartModel cart = commerceService.getCurrentCart();
        BigDecimal total = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal subtotal = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

        for (final CartEntryModel entry : cart.getEntries()) {
            final BigDecimal entryTotal = BigDecimal.valueOf(entry.getProduct().getPrice().doubleValue() * entry.getQuantity());
            entry.setTotal(entryTotal);
            cartEntryService.save(entry);

            total = total.add(entryTotal);
            subtotal = subtotal.add(entryTotal);
        }
        cart.setTotal(total);
        cart.setSubtotal(subtotal);
        cartService.save(cart);
    }
}
