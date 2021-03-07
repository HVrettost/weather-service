#weather-service
A weather service that retrieves weather data from a 3rd party API(Open Weather Map - https://openweathermap.org/), handles them and exposes API endpoints for usage.

#Technologies
- Java 14
- Docker
- Mongo DB 3.6
- Gradle 6.7
- Spring Libraries: Boot, Security, Data
- Libraries: Guava, Lombock
- Wiremock
- Spock testing framework

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

*Notice: If there is already a container that is running then run task `./gradlew wiremockStop` in order to remove container and image. This will take into account the new json files.

#Endpoints
Daily forecast endpoint -> http://{{environment}}:{{port}}/api/weather/forecast/daily?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/daily?lat=37.971835&lon=23.737066&units=metric&lang=en
 

Hourly forecast endpoint -> http://{{environment}}:{{port}}/api/weather/forecast/hourly?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/hourly?lat=37.971835&lon=23.737066&units=metric&lang=en

Minutely forecast endpoint -> http://{{environment}}:{{port}}/api/weather/forecast/minutely?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/minutely?lat=37.971835&lon=23.737066&units=metric&lang=en

Hourly forecast endpoint -> http://{{environment}}:{{port}}/api/weather/forecast/hourly?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/hourly?lat=37.971835&lon=23.737066&units=metric&lang=en

Weather alerts endpoint -> http://{{environment}}:{{port}}/api/weather/alerts?lat={latitude}&lon={longitude}&units={units}&lang={language}
- example -> http://localhost:8700/api/weather/forecast/minutely?lat=37.971835&lon=23.737066&units=metric&lang=en

* Units and Language in the above endpoints examples are optional and can be omitted, lat(latitude) and lon(longitude) attributes are required and if omitted the call will fail
* All Date and times are int UTC but also the timezone and offset are contained to convert to whichever time

*Notice: Along with these examples in the project exists a full postman-collection that can be imported in Postman and recreate the API calls

