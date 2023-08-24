package com.lucas.ecommerce.dto.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestData {
    private String username;
    private String password;
    private String email;
    private String phone;
    private List<RoleRequestData> roles;

}
