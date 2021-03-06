package myreika.weather.dto.current;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WindInfoDto {

    private double speed;
    private int windDirectionInDegrees;
    private double gust;
}
