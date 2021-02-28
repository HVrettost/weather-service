package myreika.weather.dto.owm.forecast.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Daily {

    @JsonProperty(value = "dt")
    private int dateTime;
    private int sunrise;
    private int sunset;

    @JsonProperty(value = "temp")
    private Temperature temperature;

    @JsonProperty(value = "feels_like")
    private FeelsLike feelsLike;
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
