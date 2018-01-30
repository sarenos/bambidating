package com.bambidating.model.requestModel;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageDialogModel {
    @NotNull(message="messageToUserId not present")
    Long messageToUserId;
}
