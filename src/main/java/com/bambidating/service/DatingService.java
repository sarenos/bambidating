package com.bambidating.service;

import com.bambidating.model.requestModel.SelectDatingUserModel;
import com.bambidating.model.responseModel.BaseResponse;

public interface DatingService {
    BaseResponse getDatingUsers();
    BaseResponse selectDatingUser(SelectDatingUserModel selectDatingUserModel);
}
