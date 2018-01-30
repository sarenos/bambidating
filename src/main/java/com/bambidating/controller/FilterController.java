package com.bambidating.controller;


import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.model.requestModel.FilterModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(ControllersMapping.FILTER)
public class FilterController {

    @Autowired
    FilterService filterServise;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    BaseResponse getFilter() {
        return filterServise.getFilter();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse updateFilter(@Valid FilterModel filterModel, BindingResult result) {
        return filterServise.updateFilter(filterModel, result);
    }
}
