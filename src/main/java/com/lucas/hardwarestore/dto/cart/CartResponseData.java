package com.lucas.hardwarestore.dto.cart;

import com.lucas.hardwarestore.dto.user.UserResponseData;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class CartResponseData {
    private String code;
    private Date created;
    private Date modified;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal total;
    private UserResponseData user;
    private List<CartEntryResponseData> entries;
}
