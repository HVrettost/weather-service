package myreika.weather.request

import org.springframework.boot.test.web.client.TestRestTemplate

class DailyForecastRequest extends Request {

    private TestRestTemplate restTemplate
    private String url = '%s/api/weather/forecast/daily?lat=%s&lon=%s'

    DailyForecastRequest(TestRestTemplate testRestTemplate, double latitude, double longitude, String units = null, String language = null) {
        this.restTemplate = testRestTemplate
        url = String.format(url, HOST, latitude, longitude)
        url = units != null ? url += String.format('&units=%s', units) : url
        url = language != null ? url += String.format('&lang=%s', language) : url

    }

    def getDailyForecast() {
        restTemplate.getForObject(url, Object)
    }
}
