package com.bambidating.model.requestModel;

import com.bambidating.controller.Utils.Gender;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class FilterModel {

    @NotNull(message="minAge not present")
    @Min(value = 14,message = "age must be 14+") @Max(value = 99,message = "age max 99")
    Integer minAge;

    @NotNull(message="maxAge not present")
    @Min(value = 14,message = "age must be 14+") @Max(value = 99,message = "age max 99")
    Integer maxAge;

    @NotNull(message="gender not present")
    Gender gender;

    @NotNull(message="withPhoto not present")
    Integer withPhoto;

    @NotNull(message="online not present")
    Integer online;
}
