package app.dtos.request;

import lombok.Data;

@Data
public class UpdateTaskRequest {
    private String userName;
    private String taskId;
    private boolean completed;
    private String description;
}
