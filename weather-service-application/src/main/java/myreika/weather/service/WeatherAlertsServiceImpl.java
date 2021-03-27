package myreika.weather.service;

import myreika.weather.dao.database.metrics.WeatherApiCallMetricsDao;
import myreika.weather.dao.service.owm.WeatherAlertsDao;
import myreika.weather.domain.Coordinates;
import myreika.weather.domain.enums.metrics.ApiCallType;
import myreika.weather.dto.alerts.WeatherAlertsDto;
import myreika.weather.validator.CoordinatesValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.UnitsValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeatherAlertsServiceImpl implements WeatherAlertsService {

    private final WeatherAlertsDao weatherAlertsDao;
    private final CoordinatesValidator coordinatesValidator;
    private final UnitsValidator unitsValidator;
    private final LanguageValidator languageValidator;
    private final WeatherApiCallMetricsDao weatherApiCallMetricsDao;

    public WeatherAlertsServiceImpl(WeatherAlertsDao weatherAlertsDao,
                                    CoordinatesValidator coordinatesValidator,
                                    UnitsValidator unitsValidator,
                                    LanguageValidator languageValidator,
                                    WeatherApiCallMetricsDao weatherApiCallMetricsDao) {
        this.weatherAlertsDao = weatherAlertsDao;
        this.coordinatesValidator = coordinatesValidator;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.weatherApiCallMetricsDao = weatherApiCallMetricsDao;
    }

    @Override
    @Transactional
    public WeatherAlertsDto getWeatherAlerts(Coordinates coordinates, String units, String lang) {
        coordinatesValidator.validate(coordinates);
        languageValidator.validate(lang);
        unitsValidator.validate(units);

        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.WEATHER_ALERTS);

        return weatherAlertsDao.getWeatherAlerts(coordinates, units, lang);
    }
}
