package com.bambidating.converter;

import com.bambidating.entity.FavoriteUser;
import com.bambidating.model.responseModel.FavoritsUsersResponse;
import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import com.bambidating.model.responseModel.enums.ResponseStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FavoriteResponseConverter {

    public FavoritsUsersResponse buildSuccessVoidResponse() {
        FavoritsUsersResponse dur = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        return dur;
    }

    public FavoritsUsersResponse buildSuccessResponse(List<FavoriteUser> favoriteUserList) {
        FavoritsUsersResponse dur = buildBaseResponse(ResponseStatus.SUCCESS, "User logged!", ClientResponseUserStatus.USER_LOGGED);
        dur.setFavoriteUserList(favoriteUserList);
        return dur;
    }

    public FavoritsUsersResponse buildBaseResponse(ResponseStatus responseStatus, String statusMessage, ClientResponseUserStatus clientResponseUserStatus) {
        FavoritsUsersResponse userInfoResponse = new FavoritsUsersResponse();
        userInfoResponse.setStatus(responseStatus);
        userInfoResponse.setStatusMessage(statusMessage);
        return userInfoResponse;
    }

    public FavoritsUsersResponse buildServerErrorResponse() {
        FavoritsUsersResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.SERVER_ERROR, "Wrong balance", ClientResponseUserStatus.NO_ERROR);
        return authenticationLoginResponse;
    }

    public FavoritsUsersResponse buildUserNotFoundResponse() {
        FavoritsUsersResponse authenticationLoginResponse = buildBaseResponse(ResponseStatus.CLIENT_ERROR, "Users not found", ClientResponseUserStatus.USER_NOT_FOUND);
        return authenticationLoginResponse;
    }
}
