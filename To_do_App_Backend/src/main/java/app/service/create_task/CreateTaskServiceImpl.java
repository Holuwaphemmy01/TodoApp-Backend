package app.service.create_task;

import app.dtos.request.CreateTaskRequest;
import app.model.Task;
import app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskServiceImpl implements CreateTaskService {

    @Autowired
    private TaskRepository  taskRepository;


    @Override
    public String addTask(CreateTaskRequest createTaskRequest) {
        if(createTaskRequest.getTitle().isBlank()) throw new IllegalArgumentException("Title cannot be blank");
        if(createTaskRequest.getDescription().isBlank()) throw new IllegalArgumentException("Description cannot be blank");
        if(createTaskRequest.getUser_id().isBlank()) throw new IllegalArgumentException("User_id cannot be blank");

        Task task = new Task();
        task.setTitle(createTaskRequest.getTitle());
        task.setDescription(createTaskRequest.getDescription());
        task.setStartDate(createTaskRequest.getStartDate());
        task.setDueDate(createTaskRequest.getDueDate());
        task.setCompleted(false);
        task.setUserId(createTaskRequest.getUser_id());
        taskRepository.save(task);
        return "Task added successfully";
    }
}
