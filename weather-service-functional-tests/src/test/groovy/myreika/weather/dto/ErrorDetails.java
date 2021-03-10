package myreika.weather.dto;

import lombok.Getter;

@Getter
public class ErrorDetails {

    private int errorCode;
    private String message;
}