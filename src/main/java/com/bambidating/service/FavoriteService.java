package com.bambidating.service;

import com.bambidating.model.requestModel.FavoriteModel;
import com.bambidating.model.responseModel.BaseResponse;

import javax.swing.plaf.basic.BasicArrowButton;

public interface FavoriteService {
    BaseResponse addToFavorite(FavoriteModel favoriteModel);
    BaseResponse getFavorites();
    BaseResponse deleteFromFavorite(FavoriteModel favoriteModel);
}
