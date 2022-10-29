package com.lucas.hardwarestore.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponseData {
    private Long id;
    private String name;
}
