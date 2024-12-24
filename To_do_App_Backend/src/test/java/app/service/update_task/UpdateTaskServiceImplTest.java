package app.service.update_task;

import app.dtos.request.CreateTaskRequest;
import app.dtos.request.UpdateTaskRequest;
import app.dtos.response.TaskResponse;
import app.repository.TaskRepository;
import app.service.create_task.CreateTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpdateTaskServiceImplTest {

    @Autowired
    private UpdateTaskService updateTaskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CreateTaskService createTaskService;

    @Test
    public void testToCreateTaskAndUpdateTask() {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setCompleted(false);
        createTaskRequest.setTitle("title");
        createTaskRequest.setDescription("description");
        createTaskRequest.setUser_id("ade92929");
        String taskId = createTaskService.addTask(createTaskRequest);

        UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
        updateTaskRequest.setCompleted(true);
        updateTaskRequest.setTaskId(taskId);
        updateTaskRequest.setDescription("description is now updated");
        updateTaskRequest.setUserName("ade92929");
        TaskResponse result = updateTaskService.updateTask(updateTaskRequest);
        assertNotEquals(result.getDescription(), createTaskRequest.getDescription());
        assertEquals(result.getDescription(), updateTaskRequest.getDescription());
    }

}