package myreika.weather.dto.forecast.minutely;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MinutelyForecastDto {

    private double latitude;
    private double longitude;
    private String timezone;
    private long timezoneOffset;
    private List<MinutelyDto> minutely;
}
