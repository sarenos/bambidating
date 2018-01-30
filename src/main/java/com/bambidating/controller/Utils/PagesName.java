package com.bambidating.controller.Utils;

public enum PagesName {
    AUTHENTICATION,
    MAIN;

    public String value() {
        return name().toLowerCase();
    }
}
