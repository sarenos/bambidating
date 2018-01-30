package com.bambidating.service;

import com.bambidating.model.requestModel.AuthenticationModel;
import com.bambidating.model.requestModel.RegistrationModel;
import com.bambidating.model.requestModel.VkAuthenticationModel;
import com.bambidating.model.responseModel.BaseResponse;
import org.springframework.validation.BindingResult;

public interface AuthenticationService {
    BaseResponse login(AuthenticationModel authenticationModel, BindingResult result);
    BaseResponse registration(RegistrationModel registrationModel, BindingResult result);
    BaseResponse online();
}
