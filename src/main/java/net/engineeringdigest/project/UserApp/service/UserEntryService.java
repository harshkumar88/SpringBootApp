package net.engineeringdigest.project.UserApp.service;
import net.engineeringdigest.project.UserApp.entity.UserEntry;
import net.engineeringdigest.project.UserApp.repository.UserEntryRepository;
import net.engineeringdigest.project.common.DTO.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserEntryService {

    @Autowired
    private UserEntryRepository userEntryRepository;

    public List<UserEntry> getUserEntries() {
        return userEntryRepository.findAll();
    }

    public UserEntry getUserEntry(String username) {
        return userEntryRepository.findByUsername(username);
    }

    public UserEntry save(UserEntry userEntry) {

            return userEntryRepository.save(userEntry);

    }

}

