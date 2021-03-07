package myreika.weather.dto.forecast.daily;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureDto {

    private double day;
    private double minimum;
    private double maximum;
    private double night;
    private double evening;
    private double morning;
}
