package myreika.weather.dto.owm.forecast.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeelsLike {

    private double day;
    private double night;

    @JsonProperty(value = "eve")
    private double evening;

    @JsonProperty(value = "morn")
    private double morning;
}
