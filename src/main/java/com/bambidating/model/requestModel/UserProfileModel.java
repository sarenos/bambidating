package com.bambidating.model.requestModel;

import com.bambidating.controller.Utils.Gender;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserProfileModel {

    @NotBlank(message="Name not present")
    @Size(min=1, max=30, message = "Name length 5 - 30")
    String name;

    @NotNull(message="age not present")
    @Min(value = 14,message = "age must be 14+") @Max(value = 99,message = "age max 99")
    Integer age;

    @NotNull(message="gender not present")
    Gender gender;
}
