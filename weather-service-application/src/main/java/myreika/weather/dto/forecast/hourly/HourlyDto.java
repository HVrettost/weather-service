package myreika.weather.dto.forecast.hourly;

import lombok.Getter;
import lombok.Setter;
import myreika.weather.dto.forecast.WeatherDto;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class HourlyDto {

    private Instant dateTime;
    private int sunrise;
    private int sunset;
    private double temperature;
    private double feelsLike;
    private int pressure;
    private int humidity;
    private double dewPoint;
    private double windSpeed;
    private int windDegrees;
    private List<WeatherDto> weather;
    private int clouds;
    private double pop;
    private double rain;
    private double uvi;
}
