package net.engineeringdigest.project.JournalApp.controller;

import net.engineeringdigest.project.JournalApp.entitty.JournalEntry;
import net.engineeringdigest.project.JournalApp.service.JournalEntryService;
import net.engineeringdigest.project.common.DTO.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>();
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
