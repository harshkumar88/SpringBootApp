package net.engineeringdigest.journalApp.controller;
import net.engineeringdigest.journalApp.entitty.JournalEntry;
import net.engineeringdigest.journalApp.DTO.Response;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    private Map<Long, JournalEntry> journalEntries =new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public Response createJournalEntry(@RequestBody JournalEntry myjournalEntry){
       journalEntryService.saveEntry(myjournalEntry);
       return new Response("Journal Addedd Successfully",true);
    }

    @GetMapping("{id}")
    public JournalEntry getJournalEntryById(@PathVariable Long id){

        return null;
    }

    @DeleteMapping("{id}")
    public String deleteJournalEntryById(@PathVariable Long id){
        return null;
    }


    @PutMapping("{id}")
    public String updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myjournalEntry){
       return null;
    }

}
