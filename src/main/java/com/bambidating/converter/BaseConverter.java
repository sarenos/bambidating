package com.bambidating.converter;

import com.bambidating.model.responseModel.AuthenticationLoginResponse;
import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import com.bambidating.model.responseModel.enums.ResponseStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class BaseConverter {

    public AuthenticationLoginResponse buildBaseResponse(ResponseStatus responseStatus, String statusMessage, ClientResponseUserStatus clientResponseUserStatus) {
        AuthenticationLoginResponse authenticationLoginResponse = new AuthenticationLoginResponse();
        authenticationLoginResponse.setStatus(responseStatus);
        authenticationLoginResponse.setStatusMessage(statusMessage);
        authenticationLoginResponse.setClientErrorStatus(clientResponseUserStatus);
        return authenticationLoginResponse;
    }

    public AuthenticationLoginResponse buildValidateErrorResponse(BindingResult result) {
        AuthenticationLoginResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.VALIDATION_ERROR, "Validation Error!", ClientResponseUserStatus.NO_ERROR);
        authenticationLoginResponse.setFieldErrors(result.getFieldErrors());
        return authenticationLoginResponse;
    }

    public AuthenticationLoginResponse buildServerErrorResponse() {
        AuthenticationLoginResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SERVER_ERROR, "Server Error", ClientResponseUserStatus.NO_ERROR);
        return authenticationLoginResponse;
    }
}
