package myreika.weather.dto.owm.current;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Precipitation {

    private double valueInMillimetres;
    private String mode;
}
