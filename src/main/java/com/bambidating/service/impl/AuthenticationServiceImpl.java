package com.bambidating.service.impl;

import com.bambidating.converter.AuthenticationResponseConverter;
import com.bambidating.entity.Authentication;
import com.bambidating.model.requestModel.AuthenticationModel;
import com.bambidating.model.requestModel.RegistrationModel;
import com.bambidating.model.requestModel.VkAuthenticationModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.model.responseModel.AuthenticationLoginResponse;
import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import com.bambidating.repository.AuthenticationRepository;
import com.bambidating.service.AuthenticationService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.persistence.NoResultException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    AuthenticationRepository authenticationRepository;
    @Autowired
    private UserSessionManager userSessionManager;
    @Autowired
    private AuthenticationResponseConverter authenticationResponseConverter;

    public BaseResponse login(AuthenticationModel authenticationModel, BindingResult result) {
        if (result.hasErrors())
            return authenticationResponseConverter.buildValidateErrorResponse(result);
        try {
            return buildRepositoryResponse(authenticationModel);
        } catch (NoResultException e) {
            return authenticationResponseConverter.buildUserNotFoundResponse();
        } catch (Exception e) {
            return authenticationResponseConverter.buildServerErrorResponse();
        }
    }

    public BaseResponse registration(RegistrationModel registrationModel, BindingResult result) {
        LOGGER.error("messfdf12 inn={} ldap={}", "fsddf", "444");
        LOGGER.debug("messfdf12 inn={} ldap={}");
        System.out.print("gfdgh111111");
        if (result.hasErrors())
            return authenticationResponseConverter.buildValidateErrorResponse(result);
        try {
          System.out.print(registrationModel.getEmail());
          authenticationRepository.findByEmail(registrationModel.getEmail());

            return authenticationResponseConverter.buildEmailUsedResponse();
        } catch (NoResultException e) {
            Long userId = authenticationRepository.registration(registrationModel);
            userSessionManager.startSession(userId);
            return authenticationResponseConverter.buildSuccessResponse();
        } catch (Exception e) {
            return authenticationResponseConverter.buildServerErrorResponse();
        }
    }

    public BaseResponse online() {
        authenticationRepository.online(userSessionManager.getId());
        return authenticationResponseConverter.buildSuccessResponse();
    }


    private AuthenticationLoginResponse buildRepositoryResponse(AuthenticationModel authenticationModel) {
        Authentication authentication = authenticationRepository.login(authenticationModel.getEmail());
        if (authentication.getPassword().equals(DigestUtils.md5Hex(authenticationModel.getPassword()))) {
            userSessionManager.startSession(authentication.getId());
            return authenticationResponseConverter.buildSuccessResponse();
        }
        return authenticationResponseConverter.buildWrongPasswordResponse();
    }
}
