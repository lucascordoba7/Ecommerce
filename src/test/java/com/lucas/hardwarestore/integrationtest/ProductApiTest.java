package com.lucas.hardwarestore.integrationtest;

import com.lucas.hardwarestore.dto.product.ProductRequestData;
import com.lucas.hardwarestore.dto.product.ProductResponseData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ProductApiTest extends ApiTestBase {

    private static final String RESOURCE_BASE_PATH = "/api/product";

    @BeforeEach
    void beforeEach() {
        findAndDeleteAllProducts();
    }

    @Test
    void givenProductNotExists_shouldReturnNotFound() {

        var url = serverBasePath() + RESOURCE_BASE_PATH + "/128821";
        var response =
                testRestTemplate.getForEntity(url, ProductResponseData.class);

        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void givenProductExists_shouldReturnOk() {

        var url = serverBasePath() + RESOURCE_BASE_PATH;

        // create a product
        var createRequest = ProductRequestData.builder()
                .name("product-name")
                .price(BigDecimal.valueOf(11.22))
                .brand("brand-name").build();
        var createResponse =
                testRestTemplate.postForEntity(url, createRequest, ProductResponseData.class);

        assertThat(createResponse.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(createResponse.getBody()).isNotNull();
        var createdProductId = createResponse.getBody().getId();

        // get product by id
        url = serverBasePath() + RESOURCE_BASE_PATH + "/" + createdProductId;
        var getResponse =
                testRestTemplate.getForEntity(url, ProductResponseData.class);

        assertThat(getResponse.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(getResponse.getBody()).isEqualTo(createResponse.getBody());
    }

    @Test
    void givenMultipleProductsAndOneIsDeleted_shouldReturnListWithoutDeletedProduct() {

        var url = serverBasePath() + RESOURCE_BASE_PATH;

        // create a product
        var createRequest1 = ProductRequestData.builder()
                .name("product-name")
                .price(BigDecimal.valueOf(11.22))
                .brand("brand-name").build();
        var createResponse1 =
                testRestTemplate.postForEntity(url, createRequest1, ProductResponseData.class);

        assertThat(createResponse1.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(createResponse1.getBody()).isNotNull();
        var productId1 = createResponse1.getBody().getId();

        // create another product
        var createRequest2 = ProductRequestData.builder()
                .name("product-name-2")
                .price(BigDecimal.valueOf(11.22))
                .brand("brand-name").build();
        var createResponse2 =
                testRestTemplate.postForEntity(url, createRequest2, ProductResponseData.class);

        assertThat(createResponse2.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(createResponse2.getBody()).isNotNull();
        var productId2 = createResponse2.getBody().getId();

        // get all products
        var getAllResponse =
                testRestTemplate.getForEntity(url, ProductResponseData[].class);

        assertThat(getAllResponse.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(getAllResponse.getBody()).isNotEmpty();
        assertThat(Arrays.asList(getAllResponse.getBody()))
                .map(ProductResponseData::getId)
                .containsExactlyInAnyOrder(productId1, productId2);

        // delete first product
        var deleteUrl = serverBasePath() + RESOURCE_BASE_PATH + "/" + productId1;
        testRestTemplate.delete(deleteUrl);

        // get all products
        getAllResponse =
                testRestTemplate.getForEntity(url, ProductResponseData[].class);

        assertThat(getAllResponse.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(getAllResponse.getBody()).isNotEmpty();
        assertThat(Arrays.asList(getAllResponse.getBody()))
                .map(ProductResponseData::getId)
                .containsExactlyInAnyOrder(productId2);

    }

    private void findAndDeleteAllProducts() {

        var url = serverBasePath() + RESOURCE_BASE_PATH;
        var allProducts =
                testRestTemplate.getForEntity(url, ProductResponseData[].class);
        assertThat(allProducts.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(allProducts.getBody()).isNotNull();

        Arrays.stream(allProducts.getBody()).forEach(product ->
                testRestTemplate.delete(serverBasePath() + RESOURCE_BASE_PATH + "/" + product.getId())
        );
    }
}
