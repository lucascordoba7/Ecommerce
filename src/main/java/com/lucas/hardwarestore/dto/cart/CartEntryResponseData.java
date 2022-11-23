package com.lucas.hardwarestore.dto.cart;

import com.lucas.hardwarestore.dto.product.ProductResponseData;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartEntryResponseData {
    private Long quantity;
    private BigDecimal total;
    private ProductResponseData product;
}
