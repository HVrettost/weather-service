# weather-service
A weather service that retrieves weather data from a 3rd party API(Open Weather Map), handles them and exposes API endpoints for usage

#Technologies
- Java 14
- Docker
- Mongo DB
- Gradle 6.7
- Spring Libraries: Boot, Security, Data
- Libraries: Guava, Lombock
- Wiremock

#Build and Run project

1) Install java 14 thrugh skdman (not mandatory but is the best tool to handle java versions without pain)
2) Install Docker in your PC
3) `./gradlew clean build` in root folder of the project in order to clean and build the project
4) `./gradlew bootRun` to run project

*Notice: in order to run different profiles go to application.properties file and change the property to
- spring.profiles.active=prod -> grabs real data from Open Weather Map
- spring.profiles.active=local-dev -> (DEFAULT) grabs mocked data from Wiremock in order to avoid actual call to OWM

#Useful Gradle tasks
- `./gradlew wiremockStart` -> starts wiremock container and builds image (also starts automatically when invoking bootRun task which starts the server)
- `./gradlew wiremockStop` -> stops wiremock container and removes image in order for the next wiremock container start to build mappings and files

#Endpoints
Daily forecast endpoint -> http://{{environment}}:{{port}}/api/weather/forecast/daily/coordinates?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/daily/coordinates?lat=37.971835&lon=23.737066&units=metric&lang=en
-> Units and Language in the above example are optional, lat and lon attributes are optional and can be omitted

All Date and times are int UTC but also the timezone and offset are contained to convert to whichever time

