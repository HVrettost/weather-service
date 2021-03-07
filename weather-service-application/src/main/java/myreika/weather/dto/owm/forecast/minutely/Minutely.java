package myreika.weather.dto.owm.forecast.minutely;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Minutely {

    @JsonProperty(value = "dt")
    private int dateTime;
    private int precipitation;
}
