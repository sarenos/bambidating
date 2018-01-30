package com.bambidating.model.requestModel;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class UploadPhotoModel {

    @NotBlank(message="key not present")
    String key;

    @NotBlank(message="full_size not present")
    String full_size;

    @NotBlank(message="size not present")
    String size;
}
