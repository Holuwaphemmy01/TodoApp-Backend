package app.service.pending_task;

import app.dtos.response.TaskResponse;
import app.model.Task;
import app.repository.TaskRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PendingTasksImpl implements PendingTasks {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Optional<TaskResponse>> getAllPendingTasks(String username) {
        List<Task> TaskForEachUser = taskRepository.findAllByUserId(username);
        if (TaskForEachUser.isEmpty()) {
            return new ArrayList<>();
        }
        List<Optional<TaskResponse>> taskResponses = new ArrayList<>();
        for (Task task : TaskForEachUser) {
            if(!task.isCompleted()) {
                TaskResponse taskResponse = new TaskResponse();
                taskResponse.setTitle(task.getTitle());
                taskResponse.setDescription(task.getDescription());
                taskResponse.setStartDate(task.getStartDate());
                taskResponse.setDueDate(task.getDueDate());
                taskResponse.setTaskId(task.getTaskId());
                taskResponse.setCompleted(task.isCompleted());
                taskResponses.add(Optional.of(taskResponse));
            }
        }
        return taskResponses;
    }
}
