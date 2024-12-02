package net.engineeringdigest.project.JournalApp.controller;

import net.engineeringdigest.project.JournalApp.entitty.JournalEntry;
import net.engineeringdigest.project.JournalApp.service.JournalEntryService;
import net.engineeringdigest.project.common.DTO.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAll(){
        List<JournalEntry> journalEntries =journalEntryService.getJournalEntries();
        return new ResponseEntity<>(journalEntries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> createJournalEntry(@RequestBody JournalEntry myjournalEntry){
        journalEntryService.saveEntry(myjournalEntry);
        Response res=Response.builder().message("Journal Entry Created").success(true).build();
        return new ResponseEntity<>(res, HttpStatus.CREATED);
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
