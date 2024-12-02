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
    public ResponseEntity<Response> createJournalEntry(@RequestParam String userName,@RequestBody JournalEntry myjournalEntry){
        journalEntryService.saveEntry(myjournalEntry,userName);
        Response res=Response.builder().message("Journal Entry Created").success(true).build();
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String id){
        JournalEntry journalEntry = journalEntryService.getJournalEntry(id);
        if(journalEntry!=null){
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response> deleteJournalEntryById(@PathVariable String id,@RequestParam String userName){
        boolean is_deleted = journalEntryService.deleteJournalEntry(id,userName);
        String msg="Journal Deleted Successfully";
        if(!is_deleted){
            msg="Journal Entry Deletion Failed";
        }

        Response res=Response.builder().message(msg).success(is_deleted).build();

        if(is_deleted){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);

    }


    @PutMapping("{id}")
    public ResponseEntity<Response>  updateJournalEntryById(@PathVariable String id, @RequestBody JournalEntry myjournalEntry,@RequestParam String userName){
        boolean is_updated = journalEntryService.updateJournalEntry(id,myjournalEntry,userName);
        String msg="Journal Updated Successfully";
        if(!is_updated){
            msg="Journal Entry Updation Failed";
        }

        Response res=Response.builder().message(msg).success(is_updated).build();

        if(is_updated){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);

    }

}
