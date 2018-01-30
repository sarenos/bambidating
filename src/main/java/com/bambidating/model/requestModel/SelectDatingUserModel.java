package com.bambidating.model.requestModel;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class SelectDatingUserModel {

    @NotNull(message="")
    Long winnerUserId;
}
