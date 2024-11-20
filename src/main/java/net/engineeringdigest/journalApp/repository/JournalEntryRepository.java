package net.engineeringdigest.journalApp.repository;
import net.engineeringdigest.journalApp.entitty.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {


}
