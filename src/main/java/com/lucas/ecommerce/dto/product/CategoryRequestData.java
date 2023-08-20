package com.lucas.ecommerce.dto.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryRequestData {
    private String name;
}
