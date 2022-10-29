package com.lucas.hardwarestore.facade.product;

import com.lucas.hardwarestore.dto.product.ProductRequestData;
import com.lucas.hardwarestore.dto.product.ProductResponseData;
import com.lucas.hardwarestore.facade.AbstractFacadeBase;
import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.model.product.ProductModel;
import com.lucas.hardwarestore.service.GenericService;
import org.springframework.stereotype.Component;

@Component
public class ProductFacade extends AbstractFacadeBase<ProductRequestData, ProductResponseData, ProductModel> {

    public ProductFacade(final GenericService<ProductModel> service,
                         final Mapper<ProductRequestData, ProductModel> requestMapper,
                         final Mapper<ProductModel, ProductResponseData> responseMapper) {

        super(service, requestMapper, responseMapper);
    }
}
