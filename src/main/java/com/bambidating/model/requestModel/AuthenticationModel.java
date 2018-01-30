package com.bambidating.model.requestModel;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class AuthenticationModel {
    @NotBlank(message="email not present")
    @Email(message="email not valid")
    String email;

    @NotBlank(message="Password not present")
    @Size(min=5, max=50, message = "Password length 5 - 50")
    String password;
}
