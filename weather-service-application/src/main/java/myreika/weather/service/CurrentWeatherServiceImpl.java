package myreika.weather.service;

import myreika.weather.dao.CurrentWeatherDao;
import myreika.weather.dto.CoordinatesDto;
import myreika.weather.dto.CurrentWeatherDto;
import myreika.weather.validator.CityIdValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.UnitsValidator;
import myreika.weather.validator.CityValidator;
import myreika.weather.validator.CoordinatesValidator;
import myreika.weather.validator.ZipCodeValidator;

import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    CurrentWeatherDao currentWeatherDao;
    UnitsValidator unitsValidator;
    LanguageValidator languageValidator;
    CityValidator cityValidator;
    CityIdValidator cityIdValidator;
    CoordinatesValidator coordinatesValidator;
    ZipCodeValidator zipCodeValidator;

    public CurrentWeatherServiceImpl(CurrentWeatherDao currentWeatherDao,
                                     UnitsValidator unitsValidator,
                                     LanguageValidator languageValidator,
                                     CityValidator cityValidator,
                                     CityIdValidator cityIdValidator,
                                     CoordinatesValidator coordinatesValidator,
                                     ZipCodeValidator zipCodeValidator) {
        this.currentWeatherDao = currentWeatherDao;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.cityValidator = cityValidator;
        this.cityIdValidator = cityIdValidator;
        this.coordinatesValidator = coordinatesValidator;
        this.zipCodeValidator = zipCodeValidator;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        cityValidator.validate(city);

        return currentWeatherDao.getCurrentWeatherByCity(city, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCityId(String cityId, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        cityIdValidator.validate(cityId);

        return currentWeatherDao.getCurrentWeatherByCityId(cityId, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCoordinates(double latitude, double longitude, String units, String lang) {
        CoordinatesDto coordinates = new CoordinatesDto(longitude, latitude);
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        coordinatesValidator.validate(coordinates);

        return currentWeatherDao.getCurrentWeatherByCoordinates(latitude, longitude, units, lang);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByZipCode(String zipCode, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        zipCodeValidator.validate(zipCode);

        return currentWeatherDao.getCurrentWeatherByZipCode(zipCode, units, lang);
    }
}
