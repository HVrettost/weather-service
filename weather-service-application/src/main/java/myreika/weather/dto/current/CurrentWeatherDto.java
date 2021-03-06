package myreika.weather.dto.current;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
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
    private int visibility;
    private SnowDto snow;
    private RainDto rain;
    private PrecipitationDto precipitation;
    private LastUpdateDto lastUpdate;
    private Instant timeOfDataCalculation;

}
