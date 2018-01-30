package com.bambidating.repository.Exeptions;

public class LowBalanceException extends Exception {

    public LowBalanceException() {
        super();
    }

    public LowBalanceException(String message) {
        super(message);
    }
}
