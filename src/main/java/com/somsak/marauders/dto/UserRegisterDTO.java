package com.somsak.marauders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
