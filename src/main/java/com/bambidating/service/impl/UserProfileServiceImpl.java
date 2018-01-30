package com.bambidating.service.impl;

import com.bambidating.converter.UserProfileConverter;
import com.bambidating.entity.Filter;
import com.bambidating.entity.UpdateUserProfileInfo;
import com.bambidating.entity.UserProfile;
import com.bambidating.model.requestModel.UploadPhotoModel;
import com.bambidating.model.requestModel.UserProfileModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import com.bambidating.repository.FilterRepository;
import com.bambidating.repository.UserRepository;
import com.bambidating.service.UserProfileService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import static jdk.nashorn.internal.objects.NativeString.substr;
import static org.apache.commons.codec.digest.DigestUtils.md5;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FilterRepository filterRepository;

    @Autowired
    UserProfileConverter userProfileConverter;

    @Autowired
    private UserSessionManager userSessionManager;

    public BaseResponse getUserProfileInfo() {
        if(userSessionManager.getId() != null) {
            UserProfile userProfile = userRepository.getUserProfileInfoById(userSessionManager.getId());
            Filter filterModel = filterRepository.getFilter(userSessionManager.getId());
            return userProfileConverter.buildSuccessResponse(userProfile, filterModel);
        }
        return userProfileConverter.buildServerErrorResponse();
    }

    public BaseResponse updateUserProfileInfo(UserProfileModel userProfileModel, BindingResult result) {
        if(userSessionManager.getId() != null) {
            UpdateUserProfileInfo userProfile = new UpdateUserProfileInfo();
            userProfile.setId(userSessionManager.getId());
            userProfile.setAge(userProfileModel.getAge());
            userProfile.setName(userProfileModel.getName());
            userProfile.setGender(userProfileModel.getGender());
            userRepository.updateUserProfileInfo(userProfile);
        }
        return null;
    }

    public BaseResponse deleteUserProfile() {
        try {
            userRepository.deleteUserProfile(userSessionManager.getId());
            return userProfileConverter.buildSuccessVoidResponse();
        } catch (Exception e) {
            return userProfileConverter.buildServerErrorResponse();
        }
    }

    public BaseResponse uploadPhoto(UploadPhotoModel uploadPhotoModel, BindingResult result) {
        userRepository.uploadPhoto(userSessionManager.getId(), uploadPhotoModel);
        return userProfileConverter.buildSuccessUploadPhotoResponse(getPhotoUrl(uploadPhotoModel));
    }

    public String getPhotoUrl(UploadPhotoModel uploadPhotoModel){
        String url = uploadPhotoModel.getKey() + ".r" + uploadPhotoModel.getSize();
        String sign = DigestUtils.md5Hex(url + "AJHBOyn1LAEDIPax53bO91M6d3oPwSZX").substring(0, 8);
        return "https://i.onthe.io/" + url + "." + sign + ".jpg";
    }
}
