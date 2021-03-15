package myreika.weather.client;

import com.google.common.base.Strings;
import myreika.weather.config.OwmConfig;
import myreika.weather.dto.owm.forecast.daily.DailyForecast;
import myreika.weather.dto.owm.forecast.hourly.HourlyForecast;
import myreika.weather.dto.owm.forecast.minutely.MinutelyForecast;
import myreika.weather.exception.handler.OwmExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapForecastClientImpl implements OpenWeatherMapForecastClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapForecastClientImpl.class);

    private static final String BY_COORDINATES_DAILY_URL = "?lat=%s&lon=%s&exclude=current,minutely,hourly,alerts";
    private static final String BY_COORDINATES_HOURLY_URL = "?lat=%s&lon=%s&exclude=current,minutely,daily,alerts";
    private static final String BY_COORDINATES_MINUTELY_URL = "?lat=%s&lon=%s&exclude=current,hourly,daily,alerts";
    private static final String UNITS_PARAMETER_NAME = "&units=%s";
    private static final String LANG_PARAMETER_NAME = "&lang=%s";
    private static final String API_KEY_PARAMETER_NAME = "&appid=%s";

    private final RestTemplate restTemplate;
    private final OwmConfig owmConfig;
    private final OwmExceptionHandler owmExceptionHandler;

    public OpenWeatherMapForecastClientImpl(RestTemplate restTemplate,
                                            OwmConfig owmConfig,
                                            OwmExceptionHandler owmExceptionHandler) {
        this.restTemplate = restTemplate;
        this.owmConfig = owmConfig;
        this.owmExceptionHandler = owmExceptionHandler;
    }

    @Override
    public DailyForecast getDailyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        try {
            return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                    + String.format(BY_COORDINATES_DAILY_URL, latitude, longitude), units, lang), DailyForecast.class).getBody();
        } catch (HttpClientErrorException ex) {
            LOGGER.error(ex.getMessage());
            owmExceptionHandler.handleOwmException(ex);
        }

        return new DailyForecast();
    }

    @Override
    public HourlyForecast getHourlyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        try {
            return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                    + String.format(BY_COORDINATES_HOURLY_URL, latitude, longitude), units, lang), HourlyForecast.class).getBody();
        } catch (HttpClientErrorException ex) {
            LOGGER.error(ex.getMessage());
            owmExceptionHandler.handleOwmException(ex);
        }

        return new HourlyForecast();
    }

    @Override
    public MinutelyForecast getMinutelyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        try {
            return restTemplate.getForEntity(constructUrl(owmConfig.getOneCallUrl()
                    + String.format(BY_COORDINATES_MINUTELY_URL, latitude, longitude), units, lang), MinutelyForecast.class).getBody();
        } catch (HttpClientErrorException ex) {
            LOGGER.error(ex.getMessage());
            owmExceptionHandler.handleOwmException(ex);
        }

        return new MinutelyForecast();
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
