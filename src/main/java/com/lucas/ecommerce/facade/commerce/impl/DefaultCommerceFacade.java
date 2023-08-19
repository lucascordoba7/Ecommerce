package com.lucas.ecommerce.facade.commerce.impl;

import com.lucas.ecommerce.facade.commerce.CommerceFacade;
import com.lucas.ecommerce.service.calculation.CalculationService;
import com.lucas.ecommerce.service.commerce.CommerceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "commerceFacade")
public class DefaultCommerceFacade implements CommerceFacade {
    @Resource(name = "commerceService")
    private CommerceService commerceService;
    @Resource(name = "calculationService")
    private CalculationService calculationService;

    @Override
    public void addToCart(final Long productId, final Long quantity, final boolean replaceQuantity) {
        commerceService.addToCart(productId, quantity, replaceQuantity);
        calculationService.recalculate();
    }
}
