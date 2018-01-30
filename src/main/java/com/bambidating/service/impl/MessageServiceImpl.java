package com.bambidating.service.impl;

import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import com.bambidating.entity.MessageHistory;
import com.bambidating.model.requestModel.MessageHistoryModel;
import com.bambidating.model.requestModel.SendMessageModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.repository.SendMessageRepository;
import com.bambidating.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    SendMessageRepository sendMessageRepository;

    @Autowired
    private UserSessionManager userSessionManager;

    @Override
    public BaseResponse sendMessage(SendMessageModel sendMessageModel, BindingResult result) {
        sendMessageRepository.sendMessage(userSessionManager.getId(), sendMessageModel.getToUserId(), sendMessageModel.getMessageText());
        return null;
    }

    @Override
    public BaseResponse getHistory(MessageHistoryModel messageHistoryModel, BindingResult result) {
        List<MessageHistory> messageHistory = sendMessageRepository.getHistory(userSessionManager.getId(), messageHistoryModel.getWithUserId());
        return null;
    }
}
