package com.bambidating.repository;

import com.bambidating.entity.MessageHistory;
import com.bambidating.model.requestModel.MessageHistoryModel;

import java.util.List;

public interface SendMessageRepository {
    void sendMessage(Long fromUserId, Long toUserId, String messageText);
    List<MessageHistory> getHistory(Long userId, Long withUserId);
}
