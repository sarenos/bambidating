package com.bambidating.repository;

import com.bambidating.entity.Authentication;

import com.bambidating.model.requestModel.RegistrationModel;
import com.bambidating.model.requestModel.VkAuthenticationModel;

public interface AuthenticationRepository {
    Authentication login(String email);
    Authentication findByEmail(String email);
    Long registration(RegistrationModel registrationModel);
    void online(Long userId);
}
