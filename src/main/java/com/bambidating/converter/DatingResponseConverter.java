package com.bambidating.converter;

import com.bambidating.entity.DatingUser;
import com.bambidating.model.responseModel.DatingUsersResponse;
import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import com.bambidating.model.responseModel.enums.ResponseStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatingResponseConverter  {

    public DatingUsersResponse buildSuccessResponse(List<DatingUser> datingUsersList) {
        DatingUsersResponse dur = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        dur.setDatingUsersList(datingUsersList);
        return dur;
    }

    public DatingUsersResponse buildSuccessVoidResponse(){
        DatingUsersResponse dur = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        return dur;
    }

    public DatingUsersResponse buildBaseResponse(ResponseStatus responseStatus, String statusMessage, ClientResponseUserStatus clientResponseUserStatus) {
        DatingUsersResponse userInfoResponse = new DatingUsersResponse();
        userInfoResponse.setStatus(responseStatus);
        userInfoResponse.setStatusMessage(statusMessage);
        return userInfoResponse;
    }

    public DatingUsersResponse buildServerErrorResponse(){
        DatingUsersResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SERVER_ERROR, "Wrong balance", ClientResponseUserStatus.NO_ERROR);
        return authenticationLoginResponse;
    }

    public DatingUsersResponse buildUserNotFoundResponse(){
        DatingUsersResponse datingUsersResponse = buildBaseResponse(ResponseStatus.CLIENT_ERROR, "User not found", ClientResponseUserStatus.USER_NOT_FOUND);
        return datingUsersResponse;
    }
}
