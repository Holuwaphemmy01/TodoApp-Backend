package app.service.delete_task;

import app.dtos.request.CreateTaskRequest;
import app.dtos.request.DeleteTaskRequest;
import app.repository.TaskRepository;
import app.service.create_task.CreateTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteTaskServiceImplTest {
    @Autowired
    private DeleteTaskService deleteTaskService;

    @Autowired
    private CreateTaskService createTaskService;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    public void testToCreateTaskAndDeleteTaskRepositoryCountWWillBeZero(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setCompleted(false);
        createTaskRequest.setTitle("title");
        createTaskRequest.setDescription("description");
        createTaskRequest.setUser_id("femi");
        String taskId = createTaskService.addTask(createTaskRequest);
        assertEquals(1, taskRepository.count());

        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setTaskId(taskId);
        deleteTaskRequest.setUserId("femi");
        deleteTaskService.deleteTask(deleteTaskRequest);
        assertEquals(0, taskRepository.count());
    }
}