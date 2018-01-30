package com.bambidating.model.responseModel;

import com.bambidating.entity.DatingUser;
import lombok.Data;

import java.util.List;

@Data
public class DatingUsersResponse extends BaseResponse{
    List<DatingUser> datingUsersList;

}
