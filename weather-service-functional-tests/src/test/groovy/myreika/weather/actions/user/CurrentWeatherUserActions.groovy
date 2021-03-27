package myreika.weather.actions.user

import myreika.weather.request.currentweather.CurrentWeatherByCityIdRequest
import myreika.weather.request.currentweather.CurrentWeatherByCityRequest
import myreika.weather.request.currentweather.CurrentWeatherByCoordinatesRequest
import myreika.weather.request.currentweather.CurrentWeatherByZipCodeRequest
import org.springframework.boot.test.web.client.TestRestTemplate

trait CurrentWeatherUserActions {

    def getCurrentWeatherByCity(TestRestTemplate restTemplate, String city, def units = null, def language = null) {
        CurrentWeatherByCityRequest request = new CurrentWeatherByCityRequest(restTemplate, city, units, language)
        request.executeRequest()
    }

    def getCurrentWeatherByCityId(TestRestTemplate restTemplate, int cityId, def units = null, def language = null) {
        CurrentWeatherByCityIdRequest request = new CurrentWeatherByCityIdRequest(restTemplate, cityId, units, language)
        request.executeRequest()
    }

    def getCurrentWeatherByCityZipCode(TestRestTemplate restTemplate, int zipCode, def units = null, def language = null) {
        CurrentWeatherByZipCodeRequest request = new CurrentWeatherByZipCodeRequest(restTemplate, zipCode, units, language)
        request.executeRequest()
    }

    def getCurrentWeatherByCoordinates(TestRestTemplate restTemplate, double latitude, double longitude, def units = null, def language = null) {
        CurrentWeatherByCoordinatesRequest request = new CurrentWeatherByCoordinatesRequest(restTemplate, latitude, longitude, units, language)
        request.executeRequest()
    }
}
