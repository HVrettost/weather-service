package myreika.weather.converter;

import myreika.weather.dto.forecast.WeatherDto;
import myreika.weather.dto.forecast.hourly.HourlyDto;
import myreika.weather.dto.forecast.hourly.HourlyForecastDto;
import myreika.weather.dto.owm.forecast.hourly.Hourly;
import myreika.weather.dto.owm.forecast.hourly.HourlyForecast;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class HourlyForecastConverter implements Converter<HourlyForecast, HourlyForecastDto> {

    private final ModelMapper modelMapper;
    private final EpochToDateTimeConverter epochToDateTimeConverter;

    public HourlyForecastConverter(ModelMapper modelMapper, EpochToDateTimeConverter epochToDateTimeConverter) {
        this.modelMapper = modelMapper;
        this.epochToDateTimeConverter = epochToDateTimeConverter;
    }

    @Override
    public HourlyForecastDto convert(HourlyForecast hourlyForecast) {
        HourlyForecastDto hourlyForecastDto = new HourlyForecastDto();
        hourlyForecastDto.setLatitude(hourlyForecast.getLatitude());
        hourlyForecastDto.setLongitude(hourlyForecast.getLongitude());
        hourlyForecastDto.setTimezone(hourlyForecast.getTimezone());
        hourlyForecastDto.setTimezoneOffsetInSeconds(hourlyForecast.getTimezoneOffset());
        hourlyForecastDto.setHourly(hourlyForecast.getHourly()
                .stream()
                .map(this::toHourlyDto)
                .collect(Collectors.toList())
        );
        return hourlyForecastDto;
    }

    private HourlyDto toHourlyDto(Hourly hourly) {
        HourlyDto hourlyDto = new HourlyDto();
        hourlyDto.setDateTime(epochToDateTimeConverter.convert(hourly.getDateTime()));
        hourlyDto.setTemperature(hourly.getTemperature());
        hourlyDto.setFeelsLike(hourly.getFeelsLike());
        hourlyDto.setPressure(hourly.getPressure());
        hourlyDto.setHumidity(hourly.getHumidity());
        hourlyDto.setDewPoint(hourly.getDewPoint());
        hourlyDto.setWindSpeed(hourly.getWindSpeed());
        hourlyDto.setWindDegrees(hourly.getWindDegrees());
        hourlyDto.setWeather(hourly.getWeather()
                .stream()
                .map(weather -> weather == null
                        ? null
                        : modelMapper.map(weather, WeatherDto.class)).collect(Collectors.toList())
        );
        hourlyDto.setClouds(hourly.getClouds());
        hourlyDto.setPop(hourly.getPop());
        hourlyDto.setRain(hourly.getRain());
        hourlyDto.setUvi(hourly.getUvi());

        return hourlyDto;
    }
}
