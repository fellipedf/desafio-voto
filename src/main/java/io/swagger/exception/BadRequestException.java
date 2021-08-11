package io.swagger.exception;

public class BadRequestException extends RuntimeException {

    private final String errorCode;
    private final String description;

    public BadRequestException(final String code, final String description){
        super();
        this.errorCode = code;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
