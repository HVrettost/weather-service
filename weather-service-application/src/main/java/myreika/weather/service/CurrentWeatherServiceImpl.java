package myreika.weather.service;

import myreika.weather.dao.CurrentWeatherApiDao;
import myreika.weather.dto.owm.current.CurrentWeatherDto;
import myreika.weather.validator.CityValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.UnitsValidator;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    CurrentWeatherApiDao currentWeatherApiDao;
    UnitsValidator unitsValidator;
    LanguageValidator languageValidator;
    CityValidator cityValidator;

    public CurrentWeatherServiceImpl(CurrentWeatherApiDao currentWeatherApiDao,
                                     UnitsValidator unitsValidator,
                                     LanguageValidator languageValidator,
                                     CityValidator cityValidator) {
        this.currentWeatherApiDao = currentWeatherApiDao;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.cityValidator = cityValidator;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        languageValidator.validate(lang);
        unitsValidator.validate(units);
        cityValidator.validate(city);

        return currentWeatherApiDao.getCurrentWeatherByCity(city, units, lang);
    }
}
