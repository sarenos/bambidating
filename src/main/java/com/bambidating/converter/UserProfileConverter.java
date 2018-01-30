package com.bambidating.converter;

import com.bambidating.entity.Filter;
import com.bambidating.entity.UserProfile;
import com.bambidating.model.responseModel.UserInfoResponse;
import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import com.bambidating.model.responseModel.enums.ResponseStatus;
import org.springframework.stereotype.Component;

@Component
public class UserProfileConverter {
    public UserInfoResponse buildSuccessVoidResponse() {
        UserInfoResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        return authenticationLoginResponse;
    }

    public UserInfoResponse buildSuccessResponse(UserProfile userProfile, Filter filter) {
        UserInfoResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        authenticationLoginResponse.setUserProfile(userProfile);
        authenticationLoginResponse.setFilterModel(filter);
        return authenticationLoginResponse;
    }

    public UserInfoResponse buildSuccessUploadPhotoResponse(String url) {
        UserInfoResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        authenticationLoginResponse.setPhotoUrl(url);
        return authenticationLoginResponse;
    }

    public UserInfoResponse buildBaseResponse(ResponseStatus responseStatus, String statusMessage, ClientResponseUserStatus clientResponseUserStatus) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setStatus(responseStatus);
        userInfoResponse.setStatusMessage(statusMessage);
        userInfoResponse.setClientErrorStatus(clientResponseUserStatus);
        return userInfoResponse;
    }

    public UserInfoResponse buildServerErrorResponse() {
        UserInfoResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SERVER_ERROR, "Server Error", ClientResponseUserStatus.NO_ERROR);
        return authenticationLoginResponse;
    }
}
