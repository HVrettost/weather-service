package myreika.weather.dto.forecast.daily;

import lombok.Getter;
import lombok.Setter;
import myreika.weather.dto.forecast.WeatherDto;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class DailyDto {

    private Instant dateTime;
    private Instant sunrise;
    private Instant sunset;
    private TemperatureDto temperature;
    private FeelsLikeDto feelsLike;
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
