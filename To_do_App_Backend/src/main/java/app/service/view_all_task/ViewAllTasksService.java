package app.service.view_all_task;

import app.dtos.response.TaskResponse;
import app.model.Task;

import java.util.List;

public interface ViewAllTasksService {
    List<TaskResponse> getAllTasks(String username);
}
