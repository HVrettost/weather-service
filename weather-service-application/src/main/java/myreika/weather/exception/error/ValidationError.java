package myreika.weather.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ValidationError {

    INVALID_CITY_NAME(1000, "Invalid city name", "", HttpStatus.CONFLICT),
    INVALID_UNITS(1001, "Invalid units passed as parameter", "", HttpStatus.CONFLICT),
    INVALID_LANGUAGE(1002, "Invalid language passed as parameter", "", HttpStatus.CONFLICT),
    INVALID_CITY_ID(1003, "Invalid city id passed as parameter", "", HttpStatus.CONFLICT),
    INVALID_COORDINATES(1004, "Invalid coordinates passed as parameters", "", HttpStatus.CONFLICT);

    private final int errorCode;
    private final String message;
    private final String description;
    private final HttpStatus httpStatus;
}
