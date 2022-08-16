package com.lucas.hardwarestore.controller.product;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.dto.product.ProductRequestData;
import com.lucas.hardwarestore.dto.product.ProductResponseData;
import com.lucas.hardwarestore.facade.Facade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController extends GenericController<ProductRequestData, ProductResponseData> {
    public ProductController(final Facade<ProductRequestData, ProductResponseData> productFacade) {
        super(productFacade);
    }
}
