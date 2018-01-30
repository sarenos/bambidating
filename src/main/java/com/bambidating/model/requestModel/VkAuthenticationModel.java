package com.bambidating.model.requestModel;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class VkAuthenticationModel {
    @NotNull(message="uid not present")
    Long uid;

    @NotBlank (message="Name not present")
    @Size(min=1, max=30, message = "Name length 5 - 30")
    String first_name;

    @NotBlank(message="hash not present")
    String hash;
}
