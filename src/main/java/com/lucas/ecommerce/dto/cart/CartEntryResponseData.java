package com.lucas.ecommerce.dto.cart;

import com.lucas.ecommerce.dto.product.ProductResponseData;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartEntryResponseData {
    private Long id;
    private Long quantity;
    private BigDecimal total;
    private ProductResponseData product;
}
