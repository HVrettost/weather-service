package myreika.weather.core.currentweather

import myreika.weather.actions.CurrentWeatherUserActions
import myreika.weather.config.WeatherServiceFTSetupSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import spock.lang.Unroll

@SpringBootTest
@Configuration
class CurrentWeatherByCitySpec extends WeatherServiceFTSetupSpec implements CurrentWeatherUserActions {

    @Unroll
    def "Should return error message if units passed as parameter is invalid"() {
        given:
            def city = 'Athens'

        when: "a request is made to get the current weather by city name"
            def response = getCurrentWeatherByCity(restTemplate, city, units)

        then: 'error message is returned'
            with (response) {
                assert status == 409
                with (body) {
                    assert errorCode == 1001
                    assert message == 'Invalid units passed as parameter'
                }
            }

        where:
            units << ['imerial', 'petric', 'hello', 'imperia', 'metr', '']
    }

    @Unroll
    def "Should return error message if language passed as parameter is invalid"() {
        given:
            def city = 'Athens'

        when: "a request is made to get the current weather by city name"
            def response = getCurrentWeatherByCity(restTemplate, city, units, language)

        then: 'error message is returned'

            with(response) {
                assert status == 409
                with (body) {
                    assert errorCode == 1002
                    assert message == 'Invalid language passed as parameter'
                }
            }

        where:
            units      | language
            'imperial' | 'qw'
            'metric'   | 'greek'
            null       | 'spa'
            null       | 'ma'
    }

    @Unroll
    def "Should return error message if city passed as parameter is invalid"() {
        given:
            def city = 'a'.repeat(46)

        when: "a request is made to get the current weather by city name"
            def response = getCurrentWeatherByCity(restTemplate, city)

        then: 'error message is returned'
            with(response) {
                assert status == 409
                with (body) {
                    assert message == 'Invalid city name'
                    assert errorCode == 1000
                }
            }
    }

    @Unroll
    def "Should return 404 could not find resource(endpoint) if city passed as parameter is empty"() {
        given:
            def city = ''

        when: "a request is made to get the current weather by city name"
            def response = getCurrentWeatherByCity(restTemplate, city)

        then: 'error message is returned'
            with(response) {
                assert status == 404
                with (body) {
                    assert error == 'Not Found'
                    assert message == ''
                    assert path == '/api/weather/current/city/'
                }
            }
    }

    @Unroll
    def "Should return successful response (200 OK) if city, units and language have valid values"() {
        when: "a request is made to get the daily forecast"
            def response = getCurrentWeatherByCity(restTemplate, city, units, language)

        then: 'successful response is returned'
            with (response) {
                assert response.status == 200
                with (body) {
                    
                }
            }

        where:
            city            | units      | language
            'Athens'        | 'metric'   | 'el'
            'a'             | 'imperial' | 'eu'
            'a'.repeat(45)  | 'metric'   | null
            'Russia'        | null       | null
            'New York'      | null       | 'da'
    }
}
