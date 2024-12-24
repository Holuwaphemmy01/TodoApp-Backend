package app.service.update_task;

import app.dtos.request.UpdateTaskRequest;
import app.dtos.response.TaskResponse;
import app.model.Task;

public interface UpdateTaskService {
    TaskResponse updateTask(UpdateTaskRequest updateTaskRequest);
}
