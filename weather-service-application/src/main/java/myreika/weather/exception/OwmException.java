package myreika.weather.exception;

import lombok.Getter;
import myreika.weather.exception.dto.ErrorDetails;
import myreika.weather.exception.error.OwmClientError;
import org.springframework.http.HttpStatus;

@Getter
public class OwmException extends RuntimeException {

    private final ErrorDetails errorDetails;
    private final HttpStatus httpStatus;
    private final String description;

    public OwmException(OwmClientError owmClientError) {
        super(owmClientError.getMessage());
        this.description = owmClientError.getDescription();
        this.httpStatus = owmClientError.getHttpStatus();
        this.errorDetails = new ErrorDetails(owmClientError.getErrorCode(), owmClientError.getMessage());
    }
}
