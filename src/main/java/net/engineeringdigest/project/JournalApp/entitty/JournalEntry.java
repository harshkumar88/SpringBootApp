package net.engineeringdigest.project.JournalApp.entitty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Setter
@Getter
@Document(collection = "journal_entries")
public class JournalEntry {

    @Id
    private String id;

    private  String title;

    private  String content;

    @CreatedDate
    private Date date;

    private  boolean isDeleted=false;

    private String formattedDate;


}
