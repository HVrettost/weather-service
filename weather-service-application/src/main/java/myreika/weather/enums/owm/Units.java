package myreika.weather.enums.owm;

import lombok.Getter;

@Getter
public enum Units {
    METRIC("metric"),
    STANDARD("standard"),
    IMPERIAL("imperial");

    private final String value;

    Units(String value) {
        this.value = value;
    }
}
