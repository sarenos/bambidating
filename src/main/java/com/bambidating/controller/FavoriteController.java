package com.bambidating.controller;


import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.model.requestModel.FavoriteModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(ControllersMapping.FAVORITE)
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    BaseResponse getFavorites() {
        return favoriteService.getFavorites();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse addToFavorite(@Valid FavoriteModel favoriteModel) {
        return favoriteService.addToFavorite(favoriteModel);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody
    BaseResponse deleteFromFavorite(@Valid FavoriteModel favoriteModel) {
        return favoriteService.deleteFromFavorite(favoriteModel);
    }
}
