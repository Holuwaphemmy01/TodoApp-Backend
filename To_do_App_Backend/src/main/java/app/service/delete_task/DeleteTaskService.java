package app.service.delete_task;

import app.dtos.request.DeleteTaskRequest;

public interface DeleteTaskService {
    void deleteTask(DeleteTaskRequest deleteTaskRequest);

}
