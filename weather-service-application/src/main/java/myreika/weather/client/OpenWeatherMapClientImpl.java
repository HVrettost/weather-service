package myreika.weather.client;

import myreika.weather.config.OwmConfig;
import myreika.weather.dto.openweathermap.current.CurrentWeather;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapClientImpl implements OpenWeatherMapClient {

    OwmConfig owmConfig;
    RestTemplate restTemplate;

    public OpenWeatherMapClientImpl(OwmConfig owmConfig, RestTemplate restTemplate) {
        this.owmConfig = owmConfig;
        this.restTemplate = restTemplate;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCity(String city) {
        return restTemplate.getForEntity(owmConfig.getCurrentWeatherUrl() + "?q=" + city + "&appid=" + owmConfig.getApiKey(), CurrentWeather.class).getBody();
    }

}
