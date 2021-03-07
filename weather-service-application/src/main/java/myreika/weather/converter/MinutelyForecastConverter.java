package myreika.weather.converter;

import myreika.weather.dto.forecast.minutely.MinutelyDto;
import myreika.weather.dto.forecast.minutely.MinutelyForecastDto;
import myreika.weather.dto.owm.forecast.minutely.Minutely;
import myreika.weather.dto.owm.forecast.minutely.MinutelyForecast;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MinutelyForecastConverter implements Converter<MinutelyForecast, MinutelyForecastDto> {

    private final EpochToDateTimeConverter epochToDateTimeConverter;

    public MinutelyForecastConverter(EpochToDateTimeConverter epochToDateTimeConverter) {
        this.epochToDateTimeConverter = epochToDateTimeConverter;
    }

    @Override
    public MinutelyForecastDto convert(MinutelyForecast minutelyForecast) {
        MinutelyForecastDto minutelyForecastDto = new MinutelyForecastDto();
        minutelyForecastDto.setLatitude(minutelyForecast.getLatitude());
        minutelyForecastDto.setLongitude(minutelyForecast.getLongitude());
        minutelyForecastDto.setTimezone(minutelyForecast.getTimezone());
        minutelyForecastDto.setTimezoneOffset(minutelyForecast.getTimezoneOffset());
        minutelyForecastDto.setMinutely(minutelyForecast.getMinutely()
                .stream()
                .map(this::toMinutelyDto)
                .collect(Collectors.toList())
        );

        return minutelyForecastDto;
    }

    private MinutelyDto toMinutelyDto(Minutely minutely) {
        MinutelyDto minutelyDto = new MinutelyDto();
        minutelyDto.setDateTime(epochToDateTimeConverter.convert(minutely.getDateTime()));
        minutelyDto.setPrecipitation(minutely.getPrecipitation());

        return minutelyDto;
    }
}
