package net.engineeringdigest.project.UserApp.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user_entries")
@NoArgsConstructor

public class UserEntry {

    private String id;

    @NonNull
    @Indexed(unique = true)

    private String username;
    private String email;
    private String password;
    private boolean is_active=true;
}
