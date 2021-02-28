package myreika.weather.service;

import myreika.weather.dao.ForecastDao;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.DailyForecastDto;
import myreika.weather.validator.CoordinatesValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.UnitsValidator;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastDao forecastDao;
    private final UnitsValidator unitsValidator;
    private final LanguageValidator languageValidator;
    private final CoordinatesValidator coordinatesValidator;

    public ForecastServiceImpl(ForecastDao forecastDao,
                               UnitsValidator unitsValidator,
                               LanguageValidator languageValidator,
                               CoordinatesValidator coordinatesValidator) {
        this.forecastDao = forecastDao;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.coordinatesValidator = coordinatesValidator;
    }

    @Override
    public DailyForecastDto getDailyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        unitsValidator.validate(units);
        languageValidator.validate(lang);
        coordinatesValidator.validate(coordinates);

        return forecastDao.getDailyForecastByCoordinates(coordinates, units, lang);
    }
}
