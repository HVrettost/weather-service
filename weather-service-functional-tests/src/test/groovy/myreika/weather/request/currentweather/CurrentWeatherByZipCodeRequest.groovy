package myreika.weather.request.currentweather

import myreika.weather.request.Request
import org.springframework.boot.test.web.client.TestRestTemplate

class CurrentWeatherByZipCodeRequest implements Request {

    private TestRestTemplate restTemplate
    private String url = '%s/api/weather/current/zip-code/%s'

    CurrentWeatherByZipCodeRequest(TestRestTemplate testRestTemplate, int zipCode, def units = null, def language = null) {
        this.restTemplate = testRestTemplate
        url = String.format(url, HOST, zipCode)
        url = constructUnitsAndLanguageOptionalParameters(units, language, url)
    }

    @Override
    def constructUnitsAndLanguageOptionalParameters(String units, String language, String url) {
        url = (units != null) ? url += String.format('?units=%s', units) : url
        if (language != null && units != null) {
            url += String.format('&lang=%s', language)
        } else if (language != null && units == null) {
            url += String.format('?lang=%s', language)
        } else {
            url
        }
    }

    @Override
    def executeRequest() {
        restTemplate.getForEntity(url, Object)
    }
}
