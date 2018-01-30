package com.bambidating.model.requestModel;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageHistoryModel {

    @NotNull(message="withUserId not present")
    Long withUserId;
}
