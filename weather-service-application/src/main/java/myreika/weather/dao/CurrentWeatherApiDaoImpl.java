package myreika.weather.dao;

import myreika.weather.client.OpenWeatherMapClient;
import myreika.weather.dto.owm.current.CurrentWeatherDto;

import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherApiDaoImpl implements CurrentWeatherApiDao {

    OpenWeatherMapClient openWeatherMapClient;

    public CurrentWeatherApiDaoImpl(OpenWeatherMapClient openWeatherMapClient) {
        this.openWeatherMapClient = openWeatherMapClient;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        return openWeatherMapClient.getCurrentWeatherByCity(city, units, lang);
    }
}
