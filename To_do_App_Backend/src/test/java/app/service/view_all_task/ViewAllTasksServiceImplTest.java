package app.service.view_all_task;

import app.dtos.request.CreateTaskRequest;
import app.dtos.request.UserRegisterDto;
import app.dtos.response.TaskResponse;
import app.model.Task;
import app.repository.TaskRepository;
import app.repository.UserRepository;
import app.service.create_task.CreateTaskServiceImpl;
import app.service.register.UserRegisterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ViewAllTasksServiceImplTest {

    @Autowired
    private ViewAllTasksService viewAllTasksService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CreateTaskServiceImpl createTaskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRegisterServiceImpl userRegisterService;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void testToCreateTwoTasksAndViewAllTasks() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        userRegisterService.register(userRegisterDto);

        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setCompleted(false);
        createTaskRequest.setTitle("title");
        createTaskRequest.setDescription("description");
        createTaskRequest.setUser_id("user151515");
        createTaskService.addTask(createTaskRequest);

        CreateTaskRequest createTaskRequest1 = new CreateTaskRequest();
        createTaskRequest1.setCompleted(false);
        createTaskRequest1.setTitle("title123");
        createTaskRequest1.setDescription("description");
        createTaskRequest1.setUser_id("user151515");
        createTaskService.addTask(createTaskRequest1);

        List<TaskResponse> result = viewAllTasksService.getAllTasks("user151515");
        System.out.println(result);
        assertEquals(2, result.size());
    }
}