package myreika.weather.dto.owm.current;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sys {

    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
}
