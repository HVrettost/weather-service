package myreika.weather.converter;

import myreika.weather.dto.alerts.AlertDto;
import myreika.weather.dto.alerts.WeatherAlertsDto;
import myreika.weather.dto.owm.alerts.Alert;
import myreika.weather.dto.owm.alerts.WeatherAlerts;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WeatherAlertConverter implements Converter<WeatherAlerts, WeatherAlertsDto> {

    private final EpochToDateTimeConverter epochToDateTimeConverter;

    public WeatherAlertConverter(EpochToDateTimeConverter epochToDateTimeConverter) {
        this.epochToDateTimeConverter = epochToDateTimeConverter;
    }

    @Override
    public WeatherAlertsDto convert(WeatherAlerts weatherAlerts) {
        WeatherAlertsDto weatherAlertsDto = new WeatherAlertsDto();
        weatherAlertsDto.setLatitude(weatherAlerts.getLatitude());
        weatherAlertsDto.setLongitude(weatherAlerts.getLongitude());
        weatherAlertsDto.setTimezone(weatherAlerts.getTimezone());
        weatherAlertsDto.setTimezoneOffset(weatherAlerts.getTimezoneOffset());
        weatherAlertsDto.setAlerts(weatherAlerts.getAlerts()
                .stream()
                .map(this::toAlertDto)
                .collect(Collectors.toList())
        );
        return weatherAlertsDto;
    }

    private AlertDto toAlertDto(Alert alert) {
        AlertDto alertDto = new AlertDto();
        alertDto.setDescription(alert.getDescription());
        alertDto.setSenderName(alert.getSenderName());
        alertDto.setEvent(alert.getEvent());
        alertDto.setStart(epochToDateTimeConverter.convert(alert.getStart()));
        alertDto.setEnd(epochToDateTimeConverter.convert(alert.getEnd()));

        return alertDto;
    }


}

