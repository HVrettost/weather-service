package myreika.weather.dto.owm.forecast.hourly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HourlyForecast {

    @JsonProperty(value = "lat")
    private double latitude;

    @JsonProperty(value = "lon")
    private double longitude;

    private String timezone;

    @JsonProperty(value = "timezone_offset")
    private long timezoneOffset;

    private List<Hourly> hourly;
}
