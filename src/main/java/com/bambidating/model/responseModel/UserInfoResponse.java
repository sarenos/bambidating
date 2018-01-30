package com.bambidating.model.responseModel;

import com.bambidating.entity.Filter;
import com.bambidating.entity.UserProfile;
import com.bambidating.model.requestModel.FilterModel;
import com.bambidating.model.responseModel.enums.ClientResponseUserStatus;
import lombok.Data;

@Data
public class UserInfoResponse extends BaseResponse{
    UserProfile userProfile;
    Filter filterModel;
    ClientResponseUserStatus clientErrorStatus;
    String photoUrl;

    public int getClientErrorStatus()
    {
        return clientErrorStatus.value();
    }

}
