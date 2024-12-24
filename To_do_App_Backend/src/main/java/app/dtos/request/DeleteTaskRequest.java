package app.dtos.request;

import lombok.Data;

@Data
public class DeleteTaskRequest {
    private String taskId;
    private String userId;
}
