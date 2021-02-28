package myreika.weather.converter;

import myreika.weather.dto.forecast.DailyDto;
import myreika.weather.dto.forecast.FeelsLikeDto;
import myreika.weather.dto.forecast.WeatherDto;
import myreika.weather.dto.forecast.TemperatureDto;
import myreika.weather.dto.forecast.DailyForecastDto;

import myreika.weather.dto.owm.forecast.daily.Temperature;
import myreika.weather.dto.owm.forecast.daily.FeelsLike;
import myreika.weather.dto.owm.forecast.daily.Daily;
import myreika.weather.dto.owm.forecast.daily.DailyForecast;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DailyForecastToDailyForecastDtoConverter implements Converter<DailyForecast, DailyForecastDto> {

    private final ModelMapper modelMapper;
    private final EpochToDateTimeConverter epochToDateTimeConverter;

    public DailyForecastToDailyForecastDtoConverter(ModelMapper modelMapper, EpochToDateTimeConverter epochToDateTimeConverter) {
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
                .map(daily -> toDailyDto(daily, dailyForecast.getTimezoneOffset()))
                .collect(Collectors.toList())
        );

        return dailyForecastDto;
    }

    private DailyDto toDailyDto(Daily daily, long timezoneOffset) {
        DailyDto dailyDto = new DailyDto();
        dailyDto.setDateTime(Objects.requireNonNull(epochToDateTimeConverter.convert(daily.getDateTime())).plusSeconds(timezoneOffset));
        dailyDto.setSunrise(Objects.requireNonNull(epochToDateTimeConverter.convert(daily.getSunrise())).plusSeconds(timezoneOffset));
        dailyDto.setSunset(Objects.requireNonNull(epochToDateTimeConverter.convert(daily.getSunset())).plusSeconds(timezoneOffset));
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
