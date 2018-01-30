package com.bambidating.controller;

import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.model.requestModel.UploadPhotoModel;
import com.bambidating.model.requestModel.UserProfileModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(ControllersMapping.USER)
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	BaseResponse getUserProfileInfo() {
		return userProfileService.getUserProfileInfo();
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	BaseResponse updateUserProfile(@Valid UserProfileModel userProfileModel, BindingResult result) {
		return userProfileService.updateUserProfileInfo(userProfileModel, result);
	}

	@RequestMapping(value = "/upload_photo", method = RequestMethod.POST)
	public @ResponseBody
	BaseResponse uploadPhoto(@Valid UploadPhotoModel uploadPhotoModel, BindingResult result) {
		return userProfileService.uploadPhoto(uploadPhotoModel, result);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody
	BaseResponse deleteUserProfile() {
		return userProfileService.deleteUserProfile();
	}
}