package myreika.weather.dto.forecast.hourly;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HourlyForecastDto {

    private double latitude;
    private double longitude;
    private String timezone;
    private long timezoneOffsetInSeconds;
    private List<HourlyDto> hourly;
}
