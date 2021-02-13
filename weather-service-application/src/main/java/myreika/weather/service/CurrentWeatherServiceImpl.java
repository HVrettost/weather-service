package myreika.weather.service;

import myreika.weather.dao.CurrentWeatherApiDao;
import myreika.weather.dto.openweathermap.current.CurrentWeather;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    CurrentWeatherApiDao currentWeatherApiDao;

    public CurrentWeatherServiceImpl(CurrentWeatherApiDao currentWeatherApiDao) {
        this.currentWeatherApiDao = currentWeatherApiDao;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCity(String city) {
        return currentWeatherApiDao.getCurrentWeatherByCity(city);
    }
}
