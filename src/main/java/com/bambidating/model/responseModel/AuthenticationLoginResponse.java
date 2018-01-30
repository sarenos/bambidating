package com.bambidating.model.responseModel;

import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthenticationLoginResponse extends BaseResponse {
    ClientResponseUserStatus clientErrorStatus;
    String redirectUrl;
    List<ValidateError> validateArrors;

    public int getClientErrorStatus()
    {
        return clientErrorStatus.value();
    }

    public void setFieldErrors(List<FieldError> fieldErrors)
    {
        validateArrors = new ArrayList<ValidateError>();
        for (FieldError fieldError: fieldErrors) {
            validateArrors.add(new ValidateError(fieldError.getField(), fieldError.getDefaultMessage()));
        }
    }
}
