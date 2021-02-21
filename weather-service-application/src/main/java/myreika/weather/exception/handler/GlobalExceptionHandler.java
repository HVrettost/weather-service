package myreika.weather.exception.handler;

import myreika.weather.exception.OwmException;
import myreika.weather.exception.dto.ErrorDetails;
import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.GenericError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ ValidationException.class })
    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException validationException) {
        LOGGER.error(validationException.getDescription(), validationException);
        return new ResponseEntity<>(validationException.getErrorDetails(), validationException.getHttpStatus());
    }

    @ExceptionHandler({ OwmException.class })
    public ResponseEntity<ErrorDetails> handleOwmException(OwmException owmException) {
        LOGGER.error(owmException.getMessage(), owmException);
        return new ResponseEntity<>(owmException.getErrorDetails(), owmException.getHttpStatus());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorDetails> handleException(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
        return new ResponseEntity<>(createGenericErrorDetails(), GenericError.GENERIC_ERROR.getHttpStatus());
    }

    private ErrorDetails createGenericErrorDetails() {
        return new ErrorDetails(GenericError.GENERIC_ERROR.getErrorCode(), GenericError.GENERIC_ERROR.getMessage());
    }
}
