package myreika.weather.dto.alerts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherAlertsDto {

    private double latitude;
    private double longitude;
    private String timezone;
    private long timezoneOffsetInSeconds;
    private List<AlertDto> alerts;
}
