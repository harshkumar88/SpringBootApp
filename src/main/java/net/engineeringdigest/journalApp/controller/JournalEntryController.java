package net.engineeringdigest.journalApp.controller;
import net.engineeringdigest.journalApp.entitty.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries =new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public String createJournalEntry(@RequestBody JournalEntry myjournalEntry){
        journalEntries.put(myjournalEntry.getId(), myjournalEntry);
        return "successfully added";
    }

    @GetMapping("{id}")
    public JournalEntry getJournalEntryById(@PathVariable Long id){
        if(journalEntries.containsKey(id)){
            return journalEntries.get(id);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public String deleteJournalEntryById(@PathVariable Long id){
        journalEntries.remove(id);
        return "successfully deleted";
    }


    @PutMapping("{id}")
    public String updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myjournalEntry){
        journalEntries.put(id, myjournalEntry);
        return "successfully updated";
    }

}
