package myreika.weather.dao

import myreika.weather.client.OpenWeatherMapClient
import myreika.weather.dto.CurrentWeatherDto
import myreika.weather.dto.owm.current.CurrentWeather
import org.springframework.core.convert.ConversionService
import spock.lang.Specification

class CurrentWeatherDaoImplSpec extends Specification {

    OpenWeatherMapClient openWeatherMapClient
    ConversionService conversionService
    CurrentWeatherDao currentWeatherDao

    def setup() {
        openWeatherMapClient = Mock()
        conversionService = Mock()
        currentWeatherDao = new CurrentWeatherDaoImpl(openWeatherMapClient, conversionService)
    }

    def "Should delegate call to client and then convert response"() {
        given:
            def city = 'Athens'
            def units = 'metric'
            def lang = 'gr'
            CurrentWeather currentWeather = Mock()
            CurrentWeatherDto currentWeatherDto = Mock()

        when:
            def response = currentWeatherDao.getCurrentWeatherByCity(city, units, lang)

        then:
            1 * openWeatherMapClient.getCurrentWeatherByCity(city, units, lang) >> currentWeather
            1 * conversionService.convert(currentWeather, CurrentWeatherDto) >> currentWeatherDto
            0 * _

        and:
            response == currentWeatherDto
    }
}
