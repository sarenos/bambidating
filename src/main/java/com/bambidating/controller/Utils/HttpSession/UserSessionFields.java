package com.bambidating.controller.Utils.HttpSession;

public enum UserSessionFields {
    ID, ISLOGIN, PHOTO_BATTLE_LAST_USERS;

    public String value() {
        return name().toLowerCase();
    }
}
