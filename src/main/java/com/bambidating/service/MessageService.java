package com.bambidating.service;

import com.bambidating.model.requestModel.MessageHistoryModel;
import com.bambidating.model.requestModel.SendMessageModel;
import com.bambidating.model.responseModel.BaseResponse;
import org.springframework.validation.BindingResult;

public interface MessageService {
    BaseResponse sendMessage(SendMessageModel sendMessageModel, BindingResult result);
    BaseResponse getHistory(MessageHistoryModel messageHistoryModel, BindingResult result);
}
