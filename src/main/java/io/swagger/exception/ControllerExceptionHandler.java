package io.swagger.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.ErrorErrors;
import io.swagger.model.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletionException;

@ControllerAdvice(basePackages = "io.swagger.api")
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> handleBadRequest(final BadRequestException badRequestException){
        LOGGER.warn("Client side error. {}", badRequestException.getDescription());
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final Error error = new Error();
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        error.setStatus(httpStatus.value());

        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setCode(badRequestException.getErrorCode());
        errorErrors.setDescription(badRequestException.getDescription());

        error.setErrors(Arrays.asList(errorErrors));
        return ResponseEntity.status(httpStatus).body(error);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Error> handleHttpClientException(final HttpClientErrorException exception){
        final String errorMessage = exception.getResponseBodyAsString();
        final HttpStatus status = exception.getStatusCode();
        LOGGER.error("4xx Http error. Status {}, Response: {}", status.name(), errorMessage);


        final Error error = new Error();
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        error.setStatus(status.value());

        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setDescription(errorMessage);

        error.setErrors(Arrays.asList(errorErrors));

        return ResponseEntity.status(status).body(error);
    }


    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Error> handleHttpServerException(final HttpServerErrorException exception){
        final String errorMessage = exception.getResponseBodyAsString();
        final HttpStatus status = exception.getStatusCode();

        LOGGER.error("5xx Http error. Status {}, Response: {}", status.name(), errorMessage);

        final Error error = new Error();
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        error.setStatus(status.value());

        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setDescription(errorMessage);

        error.setErrors(Arrays.asList(errorErrors));

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CompletionException.class)
    public ResponseEntity<Error> handleCompletionException(final CompletionException exception){
        if(exception.getCause() instanceof BadRequestException){
            return handleBadRequest((BadRequestException) exception.getCause());
        }
        return handleUnexpectedException((Exception)exception.getCause());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setCode(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorErrors.setDescription(ex.getMessage());
        return ResponseEntity.badRequest().body(buildError(errorErrors));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setCode(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorErrors.setDescription(ex.getMessage());
        return ResponseEntity.badRequest().body(buildError(errorErrors));
    }

    private Error buildError(ErrorErrors errorErrors) {
        final Error error = new Error();
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        error.setErrors(Arrays.asList(errorErrors));
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return error;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleUnexpectedException(final Exception exception){
        final String errorMessage = Objects.isNull(exception.getLocalizedMessage()) ? exception.getMessage() : exception.getLocalizedMessage();
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        LOGGER.error("Unexpected Exception.  Http error. Status {}, Response: {}", status.name(), errorMessage);
        final Error error = new Error();
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        error.setStatus(status.value());

        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setDescription(status.name());

        error.setErrors(Arrays.asList(errorErrors));

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<Error> applicationException(ApplicationException e) {
        LOGGER.warn("applicationException. {}", e.getDescription());
        return createErrorInfoResponseEntity(e.getDescription(), e.getType());
    }


    private Error buildError(ErrorErrors errorErrors, HttpStatus status) {
        final Error error = new Error();
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        error.setErrors(Arrays.asList(errorErrors));
        error.setStatus(status.value());
        return error;
    }

    private ResponseEntity<Error> createErrorInfoResponseEntity(String message, HttpStatus status) {
        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setCode(status.getReasonPhrase());
        errorErrors.setDescription(message);
        final Error error = buildError(errorErrors, status);

        return new ResponseEntity<>(error, status);
    }

    private ResponseEntity<Error> createErrorInfoResponseEntity(String message, ExceptionType type) {
        HttpStatus status;
        switch (type) {
            case NO_DATA:
                status = HttpStatus.NOT_FOUND;
                break;
            default:
                status = HttpStatus.BAD_REQUEST;
        }

        final ErrorErrors errorErrors = new ErrorErrors();
        errorErrors.setCode(status.getReasonPhrase());
        errorErrors.setDescription(message);
        final Error error = buildError(errorErrors, status);

        return new ResponseEntity<>(error, status);
    }
}
