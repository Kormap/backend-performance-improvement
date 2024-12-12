package com.performance.improvement.common.exception;

public class AlreadyExistsException extends RuntimeException {
    private String message;

    public AlreadyExistsException(String message) {
        super("해당 "+ message + " 은 이미 존재합니다.");
    }
}
