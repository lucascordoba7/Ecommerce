package com.lucas.ecommerce.facade.product;

import com.lucas.ecommerce.dto.product.ProductRequestData;
import com.lucas.ecommerce.dto.product.ProductResponseData;
import com.lucas.ecommerce.facade.AbstractFacadeBase;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.ProductModel;
import com.lucas.ecommerce.service.GenericService;
import org.springframework.stereotype.Component;

@Component
public class ProductFacade extends AbstractFacadeBase<ProductRequestData, ProductResponseData, ProductModel> {

    public ProductFacade(final GenericService<ProductModel> service,
                         final Mapper<ProductRequestData, ProductModel> requestMapper,
                         final Mapper<ProductModel, ProductResponseData> responseMapper) {

        super(service, requestMapper, responseMapper);
    }
}
