package myreika.weather.client;

import com.google.common.base.Strings;
import myreika.weather.config.OwmConfig;
import myreika.weather.dto.owm.alerts.WeatherAlerts;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapWeatherAlertsClientImpl implements OpenWeatherMapWeatherAlertsClient {

    private static final String BY_COORDINATES_WEATHER_ALERTS_URL = "?lat=%s&lon=%s&exclude=current,minutely,hourly,daily";
    private static final String UNITS_PARAMETER_NAME = "&units=%s";
    private static final String LANG_PARAMETER_NAME = "&lang=%s";
    private static final String API_KEY_PARAMETER_NAME = "&appid=%s";

    private final RestTemplate restTemplate;
    private final OwmConfig owmConfig;

    public OpenWeatherMapWeatherAlertsClientImpl(RestTemplate restTemplate, OwmConfig owmConfig) {
        this.restTemplate = restTemplate;
        this.owmConfig = owmConfig;
    }

    @Override
    public WeatherAlerts getWeatherAlerts(double latitude, double longitude, String units, String lang) {
        return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                + String.format(BY_COORDINATES_WEATHER_ALERTS_URL, latitude, longitude), units, lang), WeatherAlerts.class).getBody();
    }

    private String constructUrl(String requiredUrl, String units, String lang) {
        StringBuilder builder = new StringBuilder(requiredUrl).append(String.format(API_KEY_PARAMETER_NAME, owmConfig.getApiKey()));

        if (!Strings.isNullOrEmpty(units)) {
            builder.append(String.format(UNITS_PARAMETER_NAME, units));
        }

        if (!Strings.isNullOrEmpty(lang)) {
            builder.append(String.format(LANG_PARAMETER_NAME, lang));
        }

        return builder.toString();
    }
}
