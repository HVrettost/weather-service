package myreika.weather.converter;

import myreika.weather.dto.forecast.daily.DailyDto;
import myreika.weather.dto.forecast.daily.FeelsLikeDto;
import myreika.weather.dto.forecast.WeatherDto;
import myreika.weather.dto.forecast.daily.TemperatureDto;
import myreika.weather.dto.forecast.daily.DailyForecastDto;

import myreika.weather.dto.owm.forecast.daily.Temperature;
import myreika.weather.dto.owm.forecast.daily.FeelsLike;
import myreika.weather.dto.owm.forecast.daily.Daily;
import myreika.weather.dto.owm.forecast.daily.DailyForecast;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DailyForecastConverter implements Converter<DailyForecast, DailyForecastDto> {

    private final ModelMapper modelMapper;
    private final EpochToDateTimeConverter epochToDateTimeConverter;

    public DailyForecastConverter(ModelMapper modelMapper, EpochToDateTimeConverter epochToDateTimeConverter) {
        this.modelMapper = modelMapper;
        this.epochToDateTimeConverter = epochToDateTimeConverter;
    }

    @Override
    public DailyForecastDto convert(DailyForecast dailyForecast) {
        DailyForecastDto dailyForecastDto = new DailyForecastDto();
        dailyForecastDto.setLatitude(dailyForecast.getLatitude());
        dailyForecastDto.setLongitude(dailyForecast.getLongitude());
        dailyForecastDto.setTimezone(dailyForecast.getTimezone());
        dailyForecastDto.setTimezoneOffsetInSeconds(dailyForecast.getTimezoneOffset());
        dailyForecastDto.setDaily(dailyForecast.getDaily()
                .stream()
                .map(this::toDailyDto)
                .collect(Collectors.toList())
        );

        return dailyForecastDto;
    }

    private DailyDto toDailyDto(Daily daily) {
        DailyDto dailyDto = new DailyDto();
        dailyDto.setDateTime(epochToDateTimeConverter.convert(daily.getDateTime()));
        dailyDto.setSunrise(epochToDateTimeConverter.convert(daily.getSunrise()));
        dailyDto.setSunset(epochToDateTimeConverter.convert(daily.getSunset()));
        dailyDto.setTemperature(toTemperatureDto(daily.getTemperature()));
        dailyDto.setFeelsLike(toFeelsLikeDto(daily.getFeelsLike()));
        dailyDto.setPressure(daily.getPressure());
        dailyDto.setHumidity(daily.getHumidity());
        dailyDto.setDewPoint(daily.getDewPoint());
        dailyDto.setWindSpeed(daily.getWindSpeed());
        dailyDto.setWindDegrees(daily.getWindDegrees());
        dailyDto.setWeather(daily.getWeather()
                .stream()
                .map(weather -> weather == null
                        ? null
                        : modelMapper.map(weather, WeatherDto.class)).collect(Collectors.toList())
        );
        dailyDto.setClouds(daily.getClouds());
        dailyDto.setPop(daily.getPop());
        dailyDto.setRain(daily.getRain());
        dailyDto.setUvi(daily.getUvi());

        return dailyDto;
    }

    private FeelsLikeDto toFeelsLikeDto(FeelsLike feelsLike) {
        return feelsLike == null
                ? new FeelsLikeDto()
                : modelMapper.map(feelsLike, FeelsLikeDto.class);
    }

    private TemperatureDto toTemperatureDto(Temperature temperature) {
        return temperature == null
                ? new TemperatureDto()
                : modelMapper.map(temperature, TemperatureDto.class);
    }
}
