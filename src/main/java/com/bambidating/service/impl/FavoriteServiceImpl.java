package com.bambidating.service.impl;

import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import com.bambidating.converter.FavoriteResponseConverter;
import com.bambidating.entity.FavoriteUser;
import com.bambidating.model.requestModel.FavoriteModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.repository.FavoriteRepository;
import com.bambidating.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;


@Service
public class FavoriteServiceImpl implements FavoriteService{

    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserSessionManager userSessionManager;
    @Autowired
    private FavoriteResponseConverter favoriteResponseConverter;

    public BaseResponse addToFavorite(FavoriteModel favoriteModel) {
        try {
            favoriteRepository.addToFavorite(userSessionManager.getId(), favoriteModel.getFavoriteUserId());
            return favoriteResponseConverter.buildSuccessVoidResponse();
        } catch (Exception e) {
            return favoriteResponseConverter.buildServerErrorResponse();
        }
    }

    public BaseResponse getFavorites() {
        try {
            List<FavoriteUser> favoriteUserList = favoriteRepository.getFavorites(userSessionManager.getId());
            return favoriteResponseConverter.buildSuccessResponse(favoriteUserList);
        } catch (NoResultException e) {
            return favoriteResponseConverter.buildUserNotFoundResponse();
        } catch (Exception e) {
            return favoriteResponseConverter.buildServerErrorResponse();
        }
    }

    public BaseResponse deleteFromFavorite(FavoriteModel favoriteModel) {
        try {
            favoriteRepository.deleteFromFavorite(userSessionManager.getId(), favoriteModel.getFavoriteUserId());
            return favoriteResponseConverter.buildSuccessVoidResponse();
        } catch (Exception e) {
            return favoriteResponseConverter.buildServerErrorResponse();
        }
    }

}
