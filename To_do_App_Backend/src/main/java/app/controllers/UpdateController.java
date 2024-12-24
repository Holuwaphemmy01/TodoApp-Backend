package app.controllers;

import app.dtos.request.UpdateTaskRequest;
import app.dtos.response.TaskResponse;
import app.service.update_task.UpdateTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/to-do-app")
public class UpdateController {

    @Autowired
    private UpdateTaskServiceImpl updateTaskService;

    @PostMapping("/update")
    public TaskResponse update(@RequestBody UpdateTaskRequest updateTaskRequest) {
        return updateTaskService.updateTask(updateTaskRequest);
    }
}
