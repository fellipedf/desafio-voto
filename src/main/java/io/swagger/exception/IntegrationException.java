package io.swagger.exception;


import io.swagger.model.ErrorErrors;
import lombok.Getter;

import java.util.List;

@Getter
public class IntegrationException extends RuntimeException {
    private final transient List<ErrorErrors> errors;

    public IntegrationException(final List<ErrorErrors> errors){
        super();
        this.errors = errors;
    }
}
