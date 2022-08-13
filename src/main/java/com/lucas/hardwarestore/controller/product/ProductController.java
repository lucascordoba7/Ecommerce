package com.lucas.hardwarestore.controller.product;

import com.lucas.hardwarestore.controller.GenericController;
import com.lucas.hardwarestore.model.ProductModel;
import com.lucas.hardwarestore.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController extends GenericController<ProductModel> {
    public ProductController(final GenericService<ProductModel> genericService) {
        super(genericService);
    }
}
