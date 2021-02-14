package myreika.weather.dto.owm.current;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeatherDto {

    public CoordDto coord;
    public List<WeatherDto> weather;
    public String base;
    public MainDto main;
    public int visibility;
    public WindDto wind;
    public CloudsDto clouds;
    public int dt;
    public SysDto sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;
}
