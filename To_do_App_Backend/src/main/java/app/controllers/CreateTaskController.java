package app.controllers;

import app.dtos.request.CreateTaskRequest;
import app.service.create_task.CreateTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/to-do-app")
public class CreateTaskController {

    @Autowired
    private CreateTaskService createTaskService;


    @PostMapping("/create-task")
    public String createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        try {
           return createTaskService.addTask(createTaskRequest);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
