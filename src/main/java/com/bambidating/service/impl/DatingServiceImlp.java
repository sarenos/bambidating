package com.bambidating.service.impl;

import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import com.bambidating.converter.DatingResponseConverter;
import com.bambidating.entity.DatingUser;
import com.bambidating.model.requestModel.SelectDatingUserModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.repository.DatingRepository;
import com.bambidating.service.DatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class DatingServiceImlp implements DatingService {
    @Autowired
    DatingRepository datingRepository;
    @Autowired
    private UserSessionManager userSessionManager;
    @Autowired
    private DatingResponseConverter datingResponseConverter;

    public BaseResponse getDatingUsers() {

        try {
            List<DatingUser> datingUsers = datingRepository.getDatingUsers(userSessionManager.getId());
            userSessionManager.setLastPhotoBattleUsers(datingUsers);
            return datingResponseConverter.buildSuccessResponse(datingUsers);
        } catch (NoResultException e) {
            return datingResponseConverter.buildUserNotFoundResponse();
        } catch (Exception e) {
            return datingResponseConverter.buildServerErrorResponse();
        }
    }

    public BaseResponse selectDatingUser(SelectDatingUserModel selectDatingUserModel) {

            Long winnerUserId = null;
            Long loserUserId = null;

            for(DatingUser datingUser : userSessionManager.getLastPhotoBattleUsers())
           {
               if(datingUser.getId().equals(selectDatingUserModel.getWinnerUserId())) {
                   winnerUserId = datingUser.getId();
               } else {
                   loserUserId = datingUser.getId();
               }
           }

        try {
            datingRepository.selectDatingUser(userSessionManager.getId(), winnerUserId, loserUserId);
            userSessionManager.getLastPhotoBattleUsers().clear();
            return datingResponseConverter.buildSuccessVoidResponse();
        } catch (Exception e) {
            return datingResponseConverter.buildServerErrorResponse();
        }
    }


}
