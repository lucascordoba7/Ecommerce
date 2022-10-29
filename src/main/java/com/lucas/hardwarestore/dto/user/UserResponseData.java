package com.lucas.hardwarestore.dto.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserResponseData {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private List<RoleResponseData> roles;
}
