package com.bambidating.model.responseModel;

import lombok.Data;

@Data
public class ValidateError {
    public String fieldName;
    public String errorMessage;

    public ValidateError(String fieldName, String errorMessage)
    {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }
}
