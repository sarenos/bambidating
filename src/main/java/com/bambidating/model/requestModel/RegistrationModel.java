package com.bambidating.model.requestModel;

import com.bambidating.controller.Utils.Gender;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class RegistrationModel {
    @NotBlank(message="email not present")
    @Email(message="email not valid")
    String email;

    @NotBlank (message="password not present")
    @Size(min=5, max=50, message = "Password length 5 - 50")
    String password;

    @NotBlank (message="Name not present")
    @Size(min=1, max=30, message = "Name length 5 - 30")
    String name;

    @NotNull(message="age not present")
    @Min(value = 14,message = "age must be 14+") @Max(value = 99,message = "age max 99")
    Integer age;

    @NotNull(message="gender not present")
    Gender gender;
}
