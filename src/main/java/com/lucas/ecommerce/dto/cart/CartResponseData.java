package com.lucas.ecommerce.dto.cart;

import com.lucas.ecommerce.dto.user.UserResponseData;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class CartResponseData {
    private Long id;
    private Date created;
    private Date modified;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal total;
    private UserResponseData user;
    private List<CartEntryResponseData> entries;
}
