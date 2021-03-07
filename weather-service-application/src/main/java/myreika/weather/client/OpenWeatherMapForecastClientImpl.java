package myreika.weather.client;

import com.google.common.base.Strings;
import myreika.weather.config.OwmConfig;
import myreika.weather.dto.owm.forecast.daily.DailyForecast;
import myreika.weather.dto.owm.forecast.hourly.HourlyForecast;
import myreika.weather.dto.owm.forecast.minutely.MinutelyForecast;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapForecastClientImpl implements OpenWeatherMapForecastClient {

    private static final String BY_COORDINATES_DAILY_URL = "?lat=%s&lon=%s&exclude=current,minutely,hourly,alerts";
    private static final String BY_COORDINATES_HOURLY_URL = "?lat=%s&lon=%s&exclude=current,minutely,daily,alerts";
    private static final String BY_COORDINATES_MINUTELY_URL = "?lat=%s&lon=%s&exclude=current,hourly,daily,alerts";
    private static final String UNITS_PARAMETER_NAME = "&units=%s";
    private static final String LANG_PARAMETER_NAME = "&lang=%s";
    private static final String API_KEY_PARAMETER_NAME = "&appid=%s";

    private final RestTemplate restTemplate;
    private final OwmConfig owmConfig;

    public OpenWeatherMapForecastClientImpl(RestTemplate restTemplate, OwmConfig owmConfig) {
        this.restTemplate = restTemplate;
        this.owmConfig = owmConfig;
    }

    @Override
    public DailyForecast getDailyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                + String.format(BY_COORDINATES_DAILY_URL, latitude, longitude), units, lang), DailyForecast.class).getBody();
    }

    @Override
    public HourlyForecast getHourlyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                + String.format(BY_COORDINATES_HOURLY_URL, latitude, longitude), units, lang), HourlyForecast.class).getBody();
    }

    @Override
    public MinutelyForecast getMinutelyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                + String.format(BY_COORDINATES_MINUTELY_URL, latitude, longitude), units, lang), MinutelyForecast.class).getBody();
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
