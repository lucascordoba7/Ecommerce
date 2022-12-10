package com.lucas.hardwarestore.controller.product;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.dto.product.ProductRequestData;
import com.lucas.hardwarestore.dto.product.ProductResponseData;
import com.lucas.hardwarestore.facade.Facade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Products", description = "Product controllers")
@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin("*")
public class ProductController extends GenericController<ProductRequestData, ProductResponseData> {
    public ProductController(final Facade<ProductRequestData, ProductResponseData> productFacade) {
        super(productFacade);
    }
}
