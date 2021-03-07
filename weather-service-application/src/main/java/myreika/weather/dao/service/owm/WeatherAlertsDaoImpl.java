package myreika.weather.dao.service.owm;

import myreika.weather.client.OpenWeatherMapWeatherAlertsClient;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.alerts.WeatherAlertsDto;
import myreika.weather.dto.owm.alerts.WeatherAlerts;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class WeatherAlertsDaoImpl implements WeatherAlertsDao {

    private final OpenWeatherMapWeatherAlertsClient openWeatherMapWeatherAlertsClient;
    private final ConversionService conversionService;

    public WeatherAlertsDaoImpl(OpenWeatherMapWeatherAlertsClient openWeatherMapWeatherAlertsClient,
                                ConversionService conversionService) {
        this.openWeatherMapWeatherAlertsClient = openWeatherMapWeatherAlertsClient;
        this.conversionService = conversionService;
    }

    @Override
    public WeatherAlertsDto getWeatherAlerts(Coordinates coordinates, String units, String lang) {
        WeatherAlerts alerts = openWeatherMapWeatherAlertsClient.getWeatherAlerts(coordinates.getLatitude(), coordinates.getLongitude(), units, lang);

        return conversionService.convert(alerts, WeatherAlertsDto.class);
    }
}
