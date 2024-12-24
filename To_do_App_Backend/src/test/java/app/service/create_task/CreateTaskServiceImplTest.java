package app.service.create_task;

import app.dtos.request.CreateTaskRequest;
import app.dtos.request.UserLoginRequest;
import app.dtos.request.UserRegisterDto;
import app.repository.TaskRepository;
import app.repository.UserRepository;
import app.service.login.UserLoginServiceImpl;
import app.service.register.UserRegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateTaskServiceImplTest {

    @Autowired
    private CreateTaskService createTaskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserLoginServiceImpl   userLoginService;



    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    public void testToRegisterLoginAndCreateTaskSuccessfully(){
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        userRegisterService.register(userRegisterDto);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("user151515");
        userLoginRequest.setPassword("Password");
        assertEquals(userLoginRequest.getUsername()+ " logged in successfully", userLoginService.login(userLoginRequest));

        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setCompleted(false);
        createTaskRequest.setTitle("title");
        createTaskRequest.setDescription("description");
        createTaskRequest.setUser_id(userLoginRequest.getUsername());
        createTaskService.addTask(createTaskRequest);
        assertEquals(1, taskRepository.count());
    }
}