package app.dtos.request;

import app.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskRequest {
    private String title;
    private String description;
    private Boolean completed;
    private String dueDate;
    private String startDate;
    private String user_id;
}
