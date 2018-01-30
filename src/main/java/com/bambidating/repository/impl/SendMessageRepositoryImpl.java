package com.bambidating.repository.impl;

import com.bambidating.entity.DatingUser;
import com.bambidating.entity.MessageHistory;
import com.bambidating.entity.SendMessage;
import com.bambidating.repository.SendMessageRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SendMessageRepositoryImpl implements SendMessageRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void sendMessage(Long fromUserId, Long toUserId, String messageText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setFromUserId(fromUserId);
        sendMessage.setToUserId(toUserId);
        sendMessage.setMessageText(messageText);
        entityManager.merge(sendMessage);
    }

    @Override
    public List<MessageHistory>  getHistory(Long userId, Long withUserId) {
        String query = "SELECT mh FROM MessageHistory mh where (mh.from_user_id = "+userId+" and mh.to_user_id = " + withUserId +") OR (mh.from_user_id = "+withUserId+" and mh.to_user_id = " + userId +")";
        Query q = entityManager.createQuery(query);
        return q.getResultList();
    }
}
