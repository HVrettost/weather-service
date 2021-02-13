package myreika.weather.dao;

import myreika.weather.client.OpenWeatherMapClient;
import myreika.weather.dto.openweathermap.current.CurrentWeather;

import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherApiDaoImpl implements CurrentWeatherApiDao {

    OpenWeatherMapClient openWeatherMapClient;

    public CurrentWeatherApiDaoImpl(OpenWeatherMapClient openWeatherMapClient) {
        this.openWeatherMapClient = openWeatherMapClient;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCity(String city) {
        return openWeatherMapClient.getCurrentWeatherByCity(city);
    }
}
