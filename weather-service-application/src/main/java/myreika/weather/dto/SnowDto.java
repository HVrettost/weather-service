package myreika.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SnowDto {

    private double snowVolumeLastOneHourInMillimetres;
    private double snowVolumeLastThreeHoursInMillimetres;
}
