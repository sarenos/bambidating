package com.bambidating.model.responseModel.enums;

public enum ResponseStatus {
    SUCCESS(1),
    SERVER_ERROR(2),
    CLIENT_ERROR(3),
    VALIDATION_ERROR(4);

    private int satus;

    ResponseStatus(int satus) {
        this.satus = satus;
    }

    public int value() {
        return satus;
    }

    @Override
    public String toString()
    {
        return String.valueOf(satus);
    }
}
