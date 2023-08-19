package com.lucas.ecommerce.controller.product;

import com.lucas.ecommerce.controller.GenericController;
import com.lucas.ecommerce.dto.product.ProductRequestData;
import com.lucas.ecommerce.dto.product.ProductResponseData;
import com.lucas.ecommerce.facade.Facade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Products", description = "Product controllers")
@RestController
@RequestMapping(value = "/api/product")
public class ProductController extends GenericController<ProductRequestData, ProductResponseData> {
    public ProductController(final Facade<ProductRequestData, ProductResponseData> productFacade) {
        super(productFacade);
    }
}
