package myreika.weather.client;

import com.google.common.base.Strings;

import myreika.weather.config.OwmConfig;
import myreika.weather.dto.owm.current.CurrentWeather;

import myreika.weather.exception.handler.OwmExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapClientImpl implements OpenWeatherMapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapClientImpl.class);

    private static final String BY_CITY_URL = "?q=%s";
    private static final String UNITS_PARAMETER_NAME = "&units=%s";
    private static final String LANG_PARAMETER_NAME = "&lang=%s";
    private static final String API_KEY_PARAMETER_NAME = "&appid=%s";

    private final OwmConfig owmConfig;
    private final RestTemplate restTemplate;
    private final OwmExceptionHandler owmExceptionHandler;

    public OpenWeatherMapClientImpl(OwmConfig owmConfig,
                                    RestTemplate restTemplate,
                                    OwmExceptionHandler owmExceptionHandler) {
        this.owmConfig = owmConfig;
        this.restTemplate = restTemplate;
        this.owmExceptionHandler = owmExceptionHandler;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCity(String city, String units, String lang) {
        try {
            return restTemplate.getForEntity(constructUrl(owmConfig.getCurrentWeatherUrl()
                    + String.format(BY_CITY_URL, city), units, lang), CurrentWeather.class).getBody();
        } catch (HttpClientErrorException ex) {
            LOGGER.error(ex.getMessage());
            owmExceptionHandler.handleOwmException(ex);
        }

        return new CurrentWeather();
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
