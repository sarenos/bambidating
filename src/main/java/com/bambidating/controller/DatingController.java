package com.bambidating.controller;

import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.model.requestModel.SelectDatingUserModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.service.DatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(ControllersMapping.DATING)
public class DatingController {

    @Autowired
    DatingService datingService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    BaseResponse getDatingUsers() {
        return datingService.getDatingUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse selectDatingUser(@Valid SelectDatingUserModel selectDatingUserModel) {
        return datingService.selectDatingUser(selectDatingUserModel);
    }
}
