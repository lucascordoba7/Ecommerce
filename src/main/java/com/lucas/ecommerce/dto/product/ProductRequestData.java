package com.lucas.ecommerce.dto.product;

import com.lucas.ecommerce.dto.IdRequestData;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestData {
    private String name;
    private String brand;
    private BigDecimal price;
    private List<IdRequestData> categories;
}
