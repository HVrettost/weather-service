package myreika.weather.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OwmClientError {

    RESOURCE_NOT_FOUND(2000, "Requested resource not found", "", HttpStatus.CONFLICT),
    INVALID_API_KEY(2001, "Unauthorized call to Open Weather Map using the wrong api key", "", HttpStatus.UNAUTHORIZED),
    GENERIC_ERROR(2050, "Generic Open Weather Map error", "", HttpStatus.BAD_REQUEST);

    private final int errorCode;
    private final String message;
    private final String description;
    private final HttpStatus httpStatus;
}
