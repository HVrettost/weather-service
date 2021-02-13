package myreika.weather.dto.openweathermap.current;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    public int id;
    public String main;
    public String description;
    public String icon;
}