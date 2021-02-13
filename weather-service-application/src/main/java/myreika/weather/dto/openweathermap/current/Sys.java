package myreika.weather.dto.openweathermap.current;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sys {

    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}
