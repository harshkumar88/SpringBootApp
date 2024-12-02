package net.engineeringdigest.project.JournalApp.service;
import net.engineeringdigest.project.JournalApp.entitty.JournalEntry;
import net.engineeringdigest.project.JournalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private FormatTimeService timeService;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getJournalEntries() {
        List<JournalEntry> journals=  journalEntryRepository.findAll();
        for (JournalEntry journalEntry : journals) {
            String updated_date = timeService.formatDate(journalEntry.getDate(), "yyyy-MM-dd");
            journalEntry.setFormattedDate(updated_date);
        }
        return journals;
    }

    public JournalEntry getJournalEntry(String id) {
        JournalEntry journalEntry= journalEntryRepository.findById(id).orElse(null);
        if(journalEntry != null) {
            String updated_date = timeService.formatDate(journalEntry.getDate(), "yyyy-MM-dd");
            journalEntry.setFormattedDate(updated_date);
        }

        return journalEntry;

    }

    public boolean deleteJournalEntry(String id) {
       boolean is_exist=journalEntryRepository.existsById(id);
       if(is_exist) {
           journalEntryRepository.deleteById(id);
           return true;
       }
       return false;
    }



    public boolean updateJournalEntry(String id, JournalEntry updatedJournalEntry) {

        JournalEntry journalEntry = journalEntryRepository.findById(id).orElse(null);

        if (journalEntry !=null) {
            // Update fields dynamically using reflection
            updateFieldsDynamically(journalEntry, updatedJournalEntry);
            // Save the updated entry
            journalEntryRepository.save(journalEntry);
            return true;
        }

        return false;
    }



    private void updateFieldsDynamically(Object target, Object source) {
        if (target == null || source == null) return;

        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true); // Allow access to private fields

                Object newValue = field.get(source);
                Object currentValue = field.get(target);

                // Update only if new value is not null and different
                if (newValue != null && !newValue.equals(currentValue)) {
                    field.set(target, newValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
    }

}
