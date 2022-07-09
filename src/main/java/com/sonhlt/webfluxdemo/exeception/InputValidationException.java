package com.sonhlt.webfluxdemo.exeception;

public class InputValidationException extends RuntimeException  {
    public static final String MSG = "allowed range is 10 to 20";
    public static final int errorCode = 100;
    private final int input;

    public InputValidationException(int input) {
        super(MSG);
        this.input = input;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public int getInput() {
        return this.input;
    }
}
