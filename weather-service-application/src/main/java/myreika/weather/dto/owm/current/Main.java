package myreika.weather.dto.owm.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Main {

    private double temp;

    @JsonProperty(value = "feels_like")
    private double feelsLike;

    @JsonProperty(value = "temp_min")
    private double tempMin;

    @JsonProperty(value = "temp_max")
    private double tempMax;

    private int pressure;
    private int humidity;

    @JsonProperty(value = "sea_level")
    private double seaLevel;

    @JsonProperty(value = "ground_level")
    private double groundLevel;
}
