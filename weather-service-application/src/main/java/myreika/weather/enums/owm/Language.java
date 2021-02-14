package myreika.weather.enums.owm;

import lombok.Getter;

@Getter
public enum Language {

    AFRIKKANS("af"),
    ALBANIAN("al"),
    ARABIC("ar"),
    AZERBAIJANI("az"),
    BULGARIAN("bg"),
    CATALAN("ca"),
    CZECH("cz"),
    DANISH("da"),
    GERMAN("de"),
    GREEK("el"),
    ENGLISH("en"),
    BASQUE("eu"),
    PERSIAN("fa"),
    FINNISH("fi"),
    FRENCH("fr"),
    GALICIAN("gl"),
    HEBREW("he"),
    HINDI("hi"),
    CROATIAN("hr"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KOREAN("kr"),
    LATVIAN("la"),
    LITHUANIAN("lt"),
    MACEDONIAN("mk"),
    NORWEGIAN("no"),
    DUTCH("nl"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PORTUGUESE_BRASIL("pt_br"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SWEDISH_1("sv"),
    SWEDISH_2("se"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SPANISH_1("sp"),
    SPANISH_2("es"),
    SERBIAN("sr"),
    THAI("th"),
    TURKISH("tr"),
    UKRAINIAN_1("ua"),
    UKRAINIAN_2("uk"),
    VIETNAMESE("vi"),
    CHINESE_SIMPLIFIED("zn_cn"),
    CHINESE_TRADITIONAL("zh_tw"),
    ZULU("zu");

    private final String value;

    Language(String value) {
        this.value = value;
    }
}
