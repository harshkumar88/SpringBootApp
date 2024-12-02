package net.engineeringdigest.project.common.Auth.repository;
import net.engineeringdigest.project.common.Auth.Entity.AuthEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository extends MongoRepository<AuthEntity, String > {
    AuthEntity findByToken(String token);
}
