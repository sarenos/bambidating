package com.bambidating.model.responseModel;

import com.bambidating.model.responseModel.enums.ResponseStatus;
import lombok.Data;

@Data
public class BaseResponse {
    ResponseStatus status;
    String statusMessage;

    public int getStatus()
    {
        return status.value();
    }
}
