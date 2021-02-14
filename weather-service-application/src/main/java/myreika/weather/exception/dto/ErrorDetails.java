package myreika.weather.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {

    private final int errorCode;
    private final String message;
}
