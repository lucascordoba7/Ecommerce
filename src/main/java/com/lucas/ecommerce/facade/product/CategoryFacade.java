package com.lucas.ecommerce.facade.product;

import com.lucas.ecommerce.dto.product.CategoryRequestData;
import com.lucas.ecommerce.dto.product.CategoryResponseData;
import com.lucas.ecommerce.facade.AbstractFacadeBase;
import com.lucas.ecommerce.facade.mappers.Mapper;
import com.lucas.ecommerce.model.product.CategoryModel;
import com.lucas.ecommerce.service.GenericService;
import org.springframework.stereotype.Component;

@Component
public class CategoryFacade extends AbstractFacadeBase<CategoryRequestData, CategoryResponseData, CategoryModel> {
    public CategoryFacade(GenericService<CategoryModel> service, Mapper<CategoryRequestData, CategoryModel> requestMapper, Mapper<CategoryModel, CategoryResponseData> responseMapper) {
        super(service, requestMapper, responseMapper);
    }

    @Override
    protected void setId(CategoryModel categoryModel, long id) {
        categoryModel.setId(id);
    }
}
