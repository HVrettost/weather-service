package myreika.weather.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OwmClientError {

    OWM_ERROR(2000, "", "", HttpStatus.CONFLICT);

    private final int errorCode;
    private String message;
    private String description;
    private final HttpStatus httpStatus;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
