package com.bambidating.service.impl;

import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import com.bambidating.model.requestModel.FilterModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.repository.FilterRepository;
import com.bambidating.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class FilterServiseImpl implements FilterService {

    @Autowired
    FilterRepository filterRepository;

    @Autowired
    private UserSessionManager userSessionManager;

    public BaseResponse getFilter() {
        return null;
    }

    public BaseResponse updateFilter(FilterModel userProfileModel, BindingResult result) {
        filterRepository.updateFilter(userSessionManager.getId(),userProfileModel);
        return null;
    }
}
