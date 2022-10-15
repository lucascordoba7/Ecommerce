package com.lucas.hardwarestore.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseData {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
}
