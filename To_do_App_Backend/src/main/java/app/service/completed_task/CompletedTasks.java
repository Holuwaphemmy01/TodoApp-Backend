package app.service.completed_task;

import app.dtos.response.TaskResponse;

import java.util.List;
import java.util.Optional;

public interface CompletedTasks {
    List<Optional<TaskResponse>> getCompletedTasks(String username);
}
