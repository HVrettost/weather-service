package myreika.weather.request

import org.springframework.boot.test.web.client.TestRestTemplate

class WeatherAlertsRequest extends Request {

    private TestRestTemplate restTemplate
    private String url = '%s/api/weather/alerts?lat=%s&lon=%s'

    WeatherAlertsRequest(TestRestTemplate testRestTemplate, def latitude, def longitude, def units = null, def language = null) {
        this.restTemplate = testRestTemplate
        url = String.format(url, HOST, latitude, longitude)
        url = units != null ? url += String.format('&units=%s', units) : url
        url = language != null ? url += String.format('&lang=%s', language) : url
    }

    def getWeatherAlerts() {
        restTemplate.getForEntity(url, Object)
    }
}
