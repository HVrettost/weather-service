package myreika.weather.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.client.RestTemplate
import spock.lang.Shared
import spock.lang.Specification

class WeatherServiceFTSetupSpec extends Specification {

    @Shared
    RestTemplate restTemplate

    @Shared
    ObjectMapper objectMapper

    def setupSpec() {
        restTemplate = new RestTemplate()
        objectMapper = new ObjectMapper()
    }
}
