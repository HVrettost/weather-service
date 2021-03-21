package myreika.weather.request

interface Request {

    static final String HOST = 'http://localhost:8700'

    def constructUnitsAndLanguageOptionalParameters(String units, String language, String url)

    def executeRequest()
}
