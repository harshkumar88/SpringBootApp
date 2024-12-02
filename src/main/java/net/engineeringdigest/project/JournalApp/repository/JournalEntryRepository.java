package net.engineeringdigest.project.JournalApp.repository;
import net.engineeringdigest.project.JournalApp.entitty.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {

    List<JournalEntry> getJournalEntryById(String id);
}
