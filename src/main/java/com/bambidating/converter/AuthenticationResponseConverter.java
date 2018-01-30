package com.bambidating.converter;

import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.model.responseModel.AuthenticationLoginResponse;
import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import com.bambidating.model.responseModel.enums.ResponseStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponseConverter extends BaseConverter {

    public AuthenticationLoginResponse buildSuccessResponse() {
        AuthenticationLoginResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        authenticationLoginResponse.setRedirectUrl("bambidating/" + ControllersMapping.MAIN);
        return authenticationLoginResponse;
    }

    public AuthenticationLoginResponse buildWrongPasswordResponse() {
        AuthenticationLoginResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.CLIENT_ERROR, "Wrong password!", ClientResponseUserStatus.WRONG_PASSWORD);
        return authenticationLoginResponse;
    }

    public AuthenticationLoginResponse buildUserNotFoundResponse() {
        AuthenticationLoginResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.CLIENT_ERROR, "User not found", ClientResponseUserStatus.USER_NOT_FOUND);
        return authenticationLoginResponse;
    }

    public AuthenticationLoginResponse buildEmailUsedResponse() {
        AuthenticationLoginResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.CLIENT_ERROR, "Email used!", ClientResponseUserStatus.EMAIL_USED);
        return authenticationLoginResponse;
    }
}
