package myreika.weather.client

import myreika.weather.config.OwmConfig
import myreika.weather.exception.handler.OwmExceptionHandler
import org.springframework.web.client.RestTemplate
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class OpenWeatherMapCurrentClientImplSpec extends Specification {

    OwmConfig owmConfig
    RestTemplate restTemplate
    OwmExceptionHandler owmExceptionHandler
    OpenWeatherMapCurrentClient openWeatherMapClient

    def setup() {
        owmConfig = Mock()
        restTemplate = Mock()
        restTemplate = Mock()
        openWeatherMapClient = new OpenWeatherMapCurrentClientImpl(owmConfig, restTemplate, owmExceptionHandler)
    }

    def "Should make call to get current weather data with no optional parameter"() {
        given:
            def city = 'Athens'
            def units = 'metric'
            def lang = 'gr'

        when:
            def response = openWeatherMapClient.getCurrentWeatherByCity(city, units, lang)

        then:
            1 * owmConfig.getCurrentWeatherUrl()

    }
}
