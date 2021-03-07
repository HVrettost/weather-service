package myreika.weather.service;

import myreika.weather.dao.service.owm.WeatherAlertsDao;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.alerts.WeatherAlertsDto;
import myreika.weather.validator.CoordinatesValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.UnitsValidator;
import org.springframework.stereotype.Service;

@Service
public class WeatherAlertsServiceImpl implements WeatherAlertsService {

    private final WeatherAlertsDao weatherAlertsDao;
    private final CoordinatesValidator coordinatesValidator;
    private final UnitsValidator unitsValidator;
    private final LanguageValidator languageValidator;

    public WeatherAlertsServiceImpl(WeatherAlertsDao weatherAlertsDao,
                                    CoordinatesValidator coordinatesValidator,
                                    UnitsValidator unitsValidator,
                                    LanguageValidator languageValidator) {
        this.weatherAlertsDao = weatherAlertsDao;
        this.coordinatesValidator = coordinatesValidator;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
    }

    @Override
    public WeatherAlertsDto getWeatherAlerts(Coordinates coordinates, String units, String lang) {
        coordinatesValidator.validate(coordinates);
        languageValidator.validate(lang);
        unitsValidator.validate(units);

        return weatherAlertsDao.getWeatherAlerts(coordinates, units, lang);
    }
}
