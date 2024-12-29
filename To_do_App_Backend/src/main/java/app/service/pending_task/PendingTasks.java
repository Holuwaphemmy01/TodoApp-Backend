package app.service.pending_task;


import app.dtos.response.TaskResponse;

import java.util.List;
import java.util.Optional;

public interface PendingTasks {
    List<Optional<TaskResponse>> getAllPendingTasks(String username);
}
