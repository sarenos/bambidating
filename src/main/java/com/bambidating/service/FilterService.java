package com.bambidating.service;

import com.bambidating.model.requestModel.FilterModel;
import com.bambidating.model.requestModel.UserProfileModel;
import com.bambidating.model.responseModel.BaseResponse;
import org.springframework.validation.BindingResult;

public interface FilterService {
    BaseResponse getFilter();
    BaseResponse updateFilter(FilterModel userProfileModel, BindingResult result);
}
