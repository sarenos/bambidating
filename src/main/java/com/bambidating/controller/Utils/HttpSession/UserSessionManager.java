package com.bambidating.controller.Utils.HttpSession;

import com.bambidating.entity.DatingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserSessionManager {
    @Autowired
    private HttpSession httpSession;

    public void startSession(Long userId){
        setLogin(true);
        setId(userId);
    }

    public Long getId() {
        return httpSession.getAttribute(UserSessionFields.ID.value()) == null ? null : (Long)httpSession.getAttribute(UserSessionFields.ID.value());
    }

    public void setId(Long id) {
        httpSession.setAttribute(UserSessionFields.ID.value(), id);
    }

    public Boolean isLogin() {
        return httpSession.getAttribute(UserSessionFields.ISLOGIN.value()) == null ? false : (Boolean)httpSession.getAttribute(UserSessionFields.ISLOGIN.value());
    }

    public void setLogin(boolean isLogin) {
        httpSession.setAttribute(UserSessionFields.ISLOGIN.value(), isLogin);
    }

    public  void  setLastPhotoBattleUsers(List<DatingUser> datingUsersList)
    {
        httpSession.setAttribute(UserSessionFields.PHOTO_BATTLE_LAST_USERS.value(), datingUsersList);
    }

    public  List<DatingUser> getLastPhotoBattleUsers()
    {
        return httpSession.getAttribute(UserSessionFields.PHOTO_BATTLE_LAST_USERS.value()) == null ? new ArrayList<DatingUser>() : (List<DatingUser>)httpSession.getAttribute(UserSessionFields.PHOTO_BATTLE_LAST_USERS.value());
    }
}
