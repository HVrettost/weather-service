package myreika.weather.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

//@Configuration
public class MongoDatabaseConfig {

    private final Environment environment;
    private final String database;

    public MongoDatabaseConfig(Environment environment) {
        this.environment = environment;
        database = environment.getProperty("spring.data.mongodb.database");
    }

    //@Bean
    public MongoOperations mongoOperations() {
        return new MongoTemplate(mongoClient(), database);
    }

    private MongoClient mongoClient() {
        return MongoClients.create(createConnectionString());
    }

    private String createConnectionString() {
        String host = environment.getProperty("spring.data.mongodb.host");
        String port = environment.getProperty("spring.data.mongodb.port");
        String user = environment.getProperty("spring.data.mongodb.username");
        String password = environment.getProperty("spring.data.mongodb.password");
        String authenticationDatabase = environment.getProperty("spring.data.mongodb.authentication-database");

        return String.format("mongodb://%s:%s@%s:%s/%s?%s", host, user, password, port, database, authenticationDatabase);
    }
}
