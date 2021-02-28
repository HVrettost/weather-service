package myreika.weather.dto.owm.forecast.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {

    private double day;

    @JsonProperty(value = "min")
    private double minimum;

    @JsonProperty(value = "max")
    private double maximum;

    private double night;

    @JsonProperty(value = "eve")
    private double evening;

    @JsonProperty(value = "morn")
    private double morning;
}
