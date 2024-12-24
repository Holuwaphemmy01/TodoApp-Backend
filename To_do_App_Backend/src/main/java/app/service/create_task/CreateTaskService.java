package app.service.create_task;

import app.dtos.request.CreateTaskRequest;

public interface CreateTaskService {
    String addTask(CreateTaskRequest createTaskRequest);
}
