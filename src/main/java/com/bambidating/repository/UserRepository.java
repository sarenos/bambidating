package com.bambidating.repository;

import com.bambidating.entity.UpdateUserProfileInfo;
import com.bambidating.entity.UserProfile;
import com.bambidating.model.requestModel.UploadPhotoModel;
import org.springframework.validation.BindingResult;

public interface UserRepository {
     UserProfile getUserProfileInfoById(Long id);
     void updateUserProfileInfo(UpdateUserProfileInfo userProfile);
     void deleteUserProfile(Long userId);
     void uploadPhoto(Long userId,UploadPhotoModel uploadPhotoModel);
}
