package myreika.weather.dto.forecast.daily;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DailyForecastDto {

    private double latitude;
    private double longitude;
    private String timezone;
    private long timezoneOffsetInSeconds;
    private List<DailyDto> daily;
}
