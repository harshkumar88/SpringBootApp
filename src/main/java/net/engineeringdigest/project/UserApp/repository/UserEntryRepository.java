package net.engineeringdigest.project.UserApp.repository;
import net.engineeringdigest.project.UserApp.entity.UserEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<UserEntry, String> {
    UserEntry findByUsername(String username);
}
