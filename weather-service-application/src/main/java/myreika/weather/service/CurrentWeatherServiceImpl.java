package myreika.weather.service;

import myreika.weather.dao.CurrentWeatherDao;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.CurrentWeatherDto;
import myreika.weather.validator.UnitsValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.CityValidator;
import myreika.weather.validator.CityIdValidator;
import myreika.weather.validator.CoordinatesValidator;

import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    CurrentWeatherDao currentWeatherDao;
    UnitsValidator unitsValidator;
    LanguageValidator languageValidator;
    CityValidator cityValidator;
    CityIdValidator cityIdValidator;
    CoordinatesValidator coordinatesValidator;

    public CurrentWeatherServiceImpl(CurrentWeatherDao currentWeatherDao,
                                     UnitsValidator unitsValidator,
                                     LanguageValidator languageValidator,
                                     CityValidator cityValidator,
                                     CityIdValidator cityIdValidator,
                                     CoordinatesValidator coordinatesValidator) {
        this.currentWeatherDao = currentWeatherDao;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.cityValidator = cityValidator;
        this.cityIdValidator = cityIdValidator;
        this.coordinatesValidator = coordinatesValidator;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        cityValidator.validate(city);

        return currentWeatherDao.getCurrentWeatherByCity(city, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCityId(int cityId, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        cityIdValidator.validate(cityId);

        return currentWeatherDao.getCurrentWeatherByCityId(cityId, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCoordinates(Coordinates coordinates, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        coordinatesValidator.validate(coordinates);

        return currentWeatherDao.getCurrentWeatherByCoordinates(coordinates, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByZipCode(int zipCode, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);

        return currentWeatherDao.getCurrentWeatherByZipCode(zipCode, units, lang);
    }
}
