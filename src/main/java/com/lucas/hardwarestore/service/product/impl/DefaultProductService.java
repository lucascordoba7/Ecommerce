package com.lucas.hardwarestore.service.product.impl;

import com.lucas.hardwarestore.dao.ProductRepository;
import com.lucas.hardwarestore.model.product.ProductModel;
import com.lucas.hardwarestore.service.product.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "productService")
public class DefaultProductService implements ProductService {
    @Resource(name = "productRepository")
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> findAll() {
        return getProductRepository().findAll();
    }

    @Override
    public Optional<ProductModel> findById(long id) {
        return getProductRepository().findById(id);
    }

    @Override
    public ProductModel create(ProductModel productModel) {
        return getProductRepository().save(productModel);
    }

    @Override
    public void delete(long id) {
        getProductRepository().deleteById(id);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
