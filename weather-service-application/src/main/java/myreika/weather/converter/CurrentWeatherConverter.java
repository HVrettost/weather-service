package myreika.weather.converter;

import myreika.weather.dto.owm.current.CurrentWeather;
import myreika.weather.dto.owm.current.Clouds;
import myreika.weather.dto.owm.current.Coord;
import myreika.weather.dto.owm.current.Main;
import myreika.weather.dto.owm.current.LastUpdate;
import myreika.weather.dto.owm.current.Rain;
import myreika.weather.dto.owm.current.Snow;
import myreika.weather.dto.owm.current.Sys;
import myreika.weather.dto.owm.current.Weather;
import myreika.weather.dto.owm.current.Precipitation;
import myreika.weather.dto.owm.current.Wind;
import myreika.weather.dto.CurrentWeatherDto;
import myreika.weather.dto.CloudsInfoDto;
import myreika.weather.dto.CoordinatesDto;
import myreika.weather.dto.MainInfoDto;
import myreika.weather.dto.GeneralInfoDto;
import myreika.weather.dto.RainDto;
import myreika.weather.dto.SnowDto;
import myreika.weather.dto.WeatherDescriptionDto;
import myreika.weather.dto.PrecipitationDto;
import myreika.weather.dto.WindInfoDto;
import myreika.weather.dto.LastUpdateDto;

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
        currentWeatherDto.setVisibility(currentWeather.getVisibility());
        currentWeatherDto.setSnow(toSnowDto(currentWeather.getSnow()));
        currentWeatherDto.setRain(toRainDto(currentWeather.getRain()));
        currentWeatherDto.setTimeOfDataCalculation(epochToDateTimeConverter.convert(currentWeather.getDt()));
        currentWeatherDto.setPrecipitation(toPrecipitationDto(currentWeather.getPrecipitation()));
        currentWeatherDto.setLastUpdate(toLastUpdateDto(currentWeather.getLastUpdate()));

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
                : new MainInfoDto(main.getTemp(), main.getFeelsLike(), main.getTempMin(), main.getTempMax(),
                main.getPressure(), main.getHumidity(), main.getSeaLevel(), main.getGroundLevel());
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

    private SnowDto toSnowDto(Snow snow) {
        return snow == null
                ? new SnowDto()
                : new SnowDto(snow.getSnowVolumeLastOneHourInMillimetres(), snow.getSnowVolumeLastThreeHoursInMillimetres());
    }

    private RainDto toRainDto(Rain rain) {
        return rain == null
                ? new RainDto()
                : new RainDto(rain.getRainVolumeLastOneHourInMillimetres(), rain.getRainVolumeLastThreeHoursInMillimetres());
    }

    private LastUpdateDto toLastUpdateDto(LastUpdate lastUpdate) {
        return lastUpdate == null
                ? new LastUpdateDto()
                : new LastUpdateDto(epochToDateTimeConverter.convert(lastUpdate.getValue()));
    }

    private PrecipitationDto toPrecipitationDto(Precipitation precipitation) {
        return precipitation == null
                ? new PrecipitationDto()
                : new PrecipitationDto(precipitation.getValueInMillimetres(), precipitation.getMode());
    }
}
