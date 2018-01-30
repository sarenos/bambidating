package com.bambidating.controller;

import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.model.requestModel.FilterModel;
import com.bambidating.model.requestModel.MessageDialogModel;
import com.bambidating.model.requestModel.MessageHistoryModel;
import com.bambidating.model.requestModel.SendMessageModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.service.FilterService;
import com.bambidating.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(ControllersMapping.MESSAGE)
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody BaseResponse sendMessage(@Valid SendMessageModel sendMessageModel, BindingResult result) {
        return messageService.sendMessage(sendMessageModel, result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody BaseResponse getHistory(@Valid MessageHistoryModel messageHistoryModel, BindingResult result) {
        return messageService.getHistory(messageHistoryModel, result);
    }
}
