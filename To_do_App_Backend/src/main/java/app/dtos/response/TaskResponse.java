package app.dtos.response;


import lombok.Data;

import java.util.Date;

@Data
public class TaskResponse {
    private String taskId;
    private String title;
    private String description;
    private boolean completed;
    private String dueDate;
    private String startDate;
}
