# weather-service
A weather service that retrieves weather data from a 3rd party API(Open Weather Map), handles them and exposes API endpoints for usage

#Build and Run project

1) Install java 14 thrugh skdman (not mandatory but is the best tool to handle java versions without pain)
2) `./gradlew clean build` in root folder of the project in order to clean and build the project
3) `./gradlew bootRun` to run project

#Endpoints
Daily forecast endpoint -> http://{{environment}}:{{port}}/api/weather/forecast/daily/coordinates?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/daily/coordinates?lat=37.971835&lon=23.737066&units=metric&lang=en
-> Units and Language in the above example are optional, lat and lon attributes are optional and can be omitted

All Date and times are int UTC but also the timezone and offset are contained to convert to whichever time
