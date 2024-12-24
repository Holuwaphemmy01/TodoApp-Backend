package app.service.update_task;

import app.dtos.request.UpdateTaskRequest;
import app.dtos.response.TaskResponse;
import app.model.Task;
import app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateTaskServiceImpl implements UpdateTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
        List<Task> task = taskRepository.findAllByUserId(updateTaskRequest.getUserName());
        for (Task task1 : task) {
            if(task1.getTaskId().equals(updateTaskRequest.getTaskId())){
                task1.setCompleted(updateTaskRequest.isCompleted());
                task1.setDescription(updateTaskRequest.getDescription());
                Task saveUpdate =  taskRepository.save(task1);
                TaskResponse taskResponse = new TaskResponse();
                taskResponse.setTaskId(saveUpdate.getTaskId());
                taskResponse.setTitle(saveUpdate.getTitle());
                taskResponse.setDescription(saveUpdate.getDescription());
                taskResponse.setCompleted(saveUpdate.isCompleted());
                return taskResponse;
            }
        }
        return null;
    }
}
