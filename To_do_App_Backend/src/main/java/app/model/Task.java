package app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Task {
    @Id
    private String taskId;
    private String userId;
    private String title;
    private String description;
    private boolean completed;
    private Date dueDate;
}
