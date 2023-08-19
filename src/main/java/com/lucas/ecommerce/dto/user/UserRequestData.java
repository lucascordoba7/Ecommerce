package com.lucas.ecommerce.dto.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRequestData {
    private String username;
    private String password;
    private String email;
    private String phone;
    private List<RoleRequestData> roles;

}
