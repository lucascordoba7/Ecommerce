package com.lucas.hardwarestore.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestData {
    private String username;
    private String password;
    private String email;
    private String phone;

}
