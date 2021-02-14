package myreika.weather.exception;

import lombok.Getter;
import myreika.weather.exception.dto.ErrorDetails;
import myreika.weather.exception.error.ValidationError;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends RuntimeException {

    private final ErrorDetails errorDetails;
    private final HttpStatus httpStatus;
    private final String description;

    public ValidationException(ValidationError validationError) {
        super(validationError.getMessage());
        this.description = validationError.getDescription();
        this.httpStatus = validationError.getHttpStatus();
        this.errorDetails = new ErrorDetails(validationError.getErrorCode(), validationError.getMessage());
    }
}
