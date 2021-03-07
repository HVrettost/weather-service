package myreika.weather.dto.forecast.daily;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeelsLikeDto {

    private double day;
    private double night;
    private double evening;
    private double morning;
}
