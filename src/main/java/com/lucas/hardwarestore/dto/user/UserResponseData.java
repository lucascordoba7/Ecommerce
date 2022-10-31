package com.lucas.hardwarestore.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseData {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private List<RoleResponseData> roles;
}
