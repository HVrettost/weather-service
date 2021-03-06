package myreika.weather.service

import myreika.weather.dao.service.owm.CurrentWeatherDao
import myreika.weather.dto.current.CurrentWeatherDto

import myreika.weather.validator.CityIdValidator
import myreika.weather.validator.CityValidator
import myreika.weather.validator.CoordinatesValidator
import myreika.weather.validator.LanguageValidator
import myreika.weather.validator.UnitsValidator

import spock.lang.Specification

class CurrentWeatherServiceImplSpec extends Specification {

    CurrentWeatherDao currentWeatherDao
    UnitsValidator unitsValidator
    LanguageValidator languageValidator
    CityValidator cityValidator
    CityIdValidator cityIdValidator
    CoordinatesValidator coordinatesValidator
    CurrentWeatherService currentWeatherService


    def setup() {
        currentWeatherDao = Mock()
        unitsValidator = Mock()
        languageValidator = Mock()
        cityValidator = Mock()
        cityIdValidator = Mock()
        coordinatesValidator = Mock()
        currentWeatherService = new CurrentWeatherServiceImpl(currentWeatherDao, unitsValidator, languageValidator, cityValidator, cityIdValidator, coordinatesValidator)
    }

    def "Should validate language, city and units parameter and delegate call to dao layer to fetch current weather"() {
        given:
            def city = 'Athens'
            def units = 'metric'
            def lang = 'gr'
            CurrentWeatherDto dto = Mock()

        when:
            def response = currentWeatherService.getCurrentWeatherByCity(city, units, lang)

        then:
            1 * languageValidator.validate(lang)
            1 * unitsValidator.validate(units)
            1 * cityValidator.validate(city)
            1 * currentWeatherDao.getCurrentWeatherByCity(city, units, lang) >> dto
            0 * _

        and:
            response == dto
    }
}
