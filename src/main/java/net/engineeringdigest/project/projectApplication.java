package net.engineeringdigest.project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoAuditing
@SpringBootApplication
@EnableMongoRepositories
public class projectApplication {
    public static void main(String[] args) {
        SpringApplication.run(projectApplication.class, args);
    }


}