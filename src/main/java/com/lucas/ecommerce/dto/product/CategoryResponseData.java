package com.lucas.ecommerce.dto.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseData {
    private long id;
    private String name;
}
