package myreika.weather.dto.owm.forecast.hourly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import myreika.weather.dto.owm.forecast.Weather;

import java.util.List;

@Getter
@Setter
public class Hourly {

    @JsonProperty(value = "dt")
    private int dateTime;
    private int sunrise;
    private int sunset;

    @JsonProperty(value = "temp")
    private double temperature;

    @JsonProperty(value = "feels_like")
    private double feelsLike;
    private int pressure;
    private int humidity;

    @JsonProperty(value = "dew_point")
    private double dewPoint;

    @JsonProperty(value = "wind_speed")
    private double windSpeed;

    @JsonProperty(value = "wind_deg")
    private int windDegrees;
    private List<Weather> weather;
    private int clouds;
    private double pop;
    private double rain;
    private double uvi;
}
