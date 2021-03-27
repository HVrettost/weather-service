package myreika.weather.service;

import myreika.weather.dao.database.metrics.WeatherApiCallMetricsDao;
import myreika.weather.dao.service.owm.CurrentWeatherDao;
import myreika.weather.domain.Coordinates;
import myreika.weather.domain.enums.metrics.ApiCallType;
import myreika.weather.dto.current.CurrentWeatherDto;
import myreika.weather.validator.UnitsValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.CityValidator;
import myreika.weather.validator.CityIdValidator;
import myreika.weather.validator.CoordinatesValidator;

import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    private final CurrentWeatherDao currentWeatherDao;
    private final UnitsValidator unitsValidator;
    private final LanguageValidator languageValidator;
    private final CityValidator cityValidator;
    private final CityIdValidator cityIdValidator;
    private final CoordinatesValidator coordinatesValidator;
    private final WeatherApiCallMetricsDao weatherApiCallMetricsDao;

    public CurrentWeatherServiceImpl(CurrentWeatherDao currentWeatherDao,
                                     UnitsValidator unitsValidator,
                                     LanguageValidator languageValidator,
                                     CityValidator cityValidator,
                                     CityIdValidator cityIdValidator,
                                     CoordinatesValidator coordinatesValidator,
                                     WeatherApiCallMetricsDao weatherApiCallMetricsDao) {
        this.currentWeatherDao = currentWeatherDao;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.cityValidator = cityValidator;
        this.cityIdValidator = cityIdValidator;
        this.coordinatesValidator = coordinatesValidator;
        this.weatherApiCallMetricsDao = weatherApiCallMetricsDao;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        validateOptionalParameters(lang, units);
        cityValidator.validate(city);

        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.CURRENT_WEATHER_BY_CITY);

        return currentWeatherDao.getCurrentWeatherByCity(city, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCityId(int cityId, String units, String lang) {
        validateOptionalParameters(lang, units);
        cityIdValidator.validate(cityId);

        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.CURRENT_WEATHER_BY_CITY_ID);

        return currentWeatherDao.getCurrentWeatherByCityId(cityId, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCoordinates(Coordinates coordinates, String units, String lang) {
        validateOptionalParameters(lang, units);
        coordinatesValidator.validate(coordinates);

        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.CURRENT_WEATHER_BY_COORDINATES);

        return currentWeatherDao.getCurrentWeatherByCoordinates(coordinates, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByZipCode(int zipCode, String units, String lang) {
        validateOptionalParameters(lang, units);

        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.CURRENT_WEATHER_BY_ZIP_CODE);

        return currentWeatherDao.getCurrentWeatherByZipCode(zipCode, units, lang);
    }

    private void validateOptionalParameters(String lang, String units) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
    }
}
