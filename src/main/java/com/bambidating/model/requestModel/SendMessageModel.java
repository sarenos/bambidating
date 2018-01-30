package com.bambidating.model.requestModel;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class SendMessageModel {

    @NotNull(message="toUserId not present")
    Long toUserId;

    @NotBlank(message="messageText not present")
    String messageText;
}
