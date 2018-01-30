package com.bambidating.model.responseModel.enums;

public enum ClientResponseUserStatus {
    NO_ERROR(0),
    USER_LOGGED(1),
    USER_NOT_FOUND(2),
    WRONG_PASSWORD(3),
    EMAIL_USED(4);

    private int userStatus;

    ClientResponseUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int value() {
        return userStatus;
    }
}
