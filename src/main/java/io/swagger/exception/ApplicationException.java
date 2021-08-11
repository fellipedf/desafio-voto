package io.swagger.exception;


import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final String description;
    private final ExceptionType type;

    public ApplicationException(final String description, final ExceptionType type){
        super();
        this.description = description;
        this.type = type;
    }
}
