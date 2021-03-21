package myreika.weather.request.forecast

import myreika.weather.request.Request
import org.springframework.boot.test.web.client.TestRestTemplate

class DailyForecastRequest implements Request {

    private TestRestTemplate restTemplate
    private String url = '%s/api/weather/forecast/daily?lat=%s&lon=%s'

    DailyForecastRequest(TestRestTemplate testRestTemplate, def latitude, def longitude, def units = null, def language = null) {
        this.restTemplate = testRestTemplate
        url = String.format(url, HOST, latitude, longitude)
        url = constructUnitsAndLanguageOptionalParameters(units, language, url)
    }

    @Override
    def constructUnitsAndLanguageOptionalParameters(String units, String language, String url) {
        url = (units != null) ? url += String.format('&units=%s', units) : url
        language != null ? url += String.format('&lang=%s', language) : url
    }

    @Override
    def executeRequest() {
        restTemplate.getForEntity(url, Object)
    }
}
