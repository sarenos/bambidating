package com.bambidating.model.responseModel;

import com.bambidating.entity.FavoriteUser;
import lombok.Data;

import java.util.List;

@Data
public class FavoritsUsersResponse extends BaseResponse{
    List<FavoriteUser> favoriteUserList;
}
