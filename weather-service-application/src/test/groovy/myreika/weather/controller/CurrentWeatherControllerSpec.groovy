package myreika.weather.controller

import myreika.weather.api.CurrentWeatherApi
import myreika.weather.dto.CurrentWeatherDto
import myreika.weather.service.CurrentWeatherService
import org.springframework.http.HttpStatus
import spock.lang.Specification

class CurrentWeatherControllerSpec extends Specification {

    CurrentWeatherService currentWeatherService
    CurrentWeatherApi currentWeatherController

    def setup() {
        currentWeatherService = Mock()
        currentWeatherController = new CurrentWeatherController(currentWeatherService)
    }

    def "Should delegate call to service and return current weather"() {
        given:
            def city = 'Athens'
            def units = 'metric'
            def lang = 'gr'
            CurrentWeatherDto currentWeatherDto = Mock()

        when:
            def response = currentWeatherController.getCurrentWeatherByCity(city, units, lang)

        then:
            1 * currentWeatherService.getCurrentWeatherByCity(city, units, lang) >> currentWeatherDto
            0 * _

        and:
            with(response) {
                body == currentWeatherDto
                statusCode == HttpStatus.OK
            }
    }
}
