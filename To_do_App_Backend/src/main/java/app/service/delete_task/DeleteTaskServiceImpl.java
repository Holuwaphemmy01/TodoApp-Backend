package app.service.delete_task;

import app.dtos.request.DeleteTaskRequest;
import app.model.Task;
import app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskServiceImpl implements DeleteTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void deleteTask(DeleteTaskRequest deleteTaskRequest) {
        Task result = taskRepository.findTasksByTaskIdAndUserId(deleteTaskRequest.getTaskId(), deleteTaskRequest.getUserId());
        if(result == null) throw new  IllegalArgumentException("Task not found");
        taskRepository.delete(result);
    }
}
