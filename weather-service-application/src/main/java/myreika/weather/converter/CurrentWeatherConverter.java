package myreika.weather.converter;

import myreika.weather.dto.*;
import myreika.weather.dto.owm.current.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrentWeatherConverter implements Converter<CurrentWeather, CurrentWeatherDto> {

    EpochToDateTimeConverter epochToDateTimeConverter;

    public CurrentWeatherConverter(EpochToDateTimeConverter epochToDateTimeConverter) {
        this.epochToDateTimeConverter = epochToDateTimeConverter;
    }

    @Override
    public CurrentWeatherDto convert(CurrentWeather currentWeather) {
        CurrentWeatherDto currentWeatherDto = new CurrentWeatherDto();
        currentWeatherDto.setCloudsInfo(toCloudInfoDto(currentWeather.getClouds()));
        currentWeatherDto.setCoordinates(toCoordinatesDto(currentWeather.getCoord()));
        currentWeatherDto.setGeneralInfo(toGeneralInfoDto(currentWeather.getSys(), currentWeather.getName()));
        currentWeatherDto.setMainInfo(toMainInfoDto(currentWeather.getMain()));
        currentWeatherDto.setWeatherDescription(toWeatherDescriptionDto(currentWeather.getWeather()));
        currentWeatherDto.setWindInfo(toWindInfoDto(currentWeather.getWind()));

        return currentWeatherDto;
    }

    private CloudsInfoDto toCloudInfoDto(Clouds clouds) {
        return clouds == null
                ? new CloudsInfoDto()
                : new CloudsInfoDto(clouds.getAll());
    }

    private CoordinatesDto toCoordinatesDto(Coord coord) {
        return coord == null
                ? new CoordinatesDto()
                : new CoordinatesDto(coord.getLon(), coord.getLat());
    }

    private GeneralInfoDto toGeneralInfoDto(Sys sys, String city) {
        return sys == null
                ? new GeneralInfoDto()
                : new GeneralInfoDto(city, sys.getCountry(),
                    epochToDateTimeConverter.convert(sys.getSunrise()),
                    epochToDateTimeConverter.convert(sys.getSunset()));
    }

    private MainInfoDto toMainInfoDto(Main main) {
        return main == null
                ? new MainInfoDto()
                : new MainInfoDto(main.getTemp(), main.getFeels_like(), main.getTemp_min(), main.getTemp_max(),
                main.getPressure(), main.getHumidity(), main.getSea_level(), main.getGround_level());
    }

    private List<WeatherDescriptionDto> toWeatherDescriptionDto(List<Weather> weatherList) {
        return weatherList == null || weatherList.size() == 0
                ? Collections.emptyList()
                : weatherList.stream()
                    .map(weather -> new WeatherDescriptionDto(weather.getMain(), weather.getDescription()))
                    .collect(Collectors.toList());
    }

    private WindInfoDto toWindInfoDto(Wind wind) {
        return wind == null
                ? new WindInfoDto()
                : new WindInfoDto(wind.getSpeed(), wind.getDeg(), wind.getGust());
    }
}
