package com.bambidating.service;

import com.bambidating.model.requestModel.UploadPhotoModel;
import com.bambidating.model.requestModel.UserProfileModel;
import com.bambidating.model.responseModel.BaseResponse;
import org.springframework.validation.BindingResult;

public interface UserProfileService {
    BaseResponse getUserProfileInfo();
    BaseResponse updateUserProfileInfo(UserProfileModel userProfileModel, BindingResult result);
    BaseResponse deleteUserProfile();
    BaseResponse uploadPhoto(UploadPhotoModel uploadPhotoModel, BindingResult result);
}
