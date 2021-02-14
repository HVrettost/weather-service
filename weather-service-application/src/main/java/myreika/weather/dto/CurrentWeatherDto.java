package myreika.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeatherDto {

    private GeneralInfoDto generalInfo;
    private CloudsInfoDto cloudsInfo;
    private CoordinatesDto coordinates;
    private MainInfoDto mainInfo;
    private List<WeatherDescriptionDto> weatherDescription;
    private WindInfoDto windInfo;
}
