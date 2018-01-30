package com.bambidating.model.requestModel;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FavoriteModel {

    @NotNull(message="")
    Long favoriteUserId;
}
