package myreika.weather.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GenericError {

    GENERIC_ERROR(5000, "Generic Error", "", HttpStatus.CONFLICT);

    private final int errorCode;
    private final String message;
    private final String description;
    private final HttpStatus httpStatus;
}
