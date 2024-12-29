package app.controllers;

import app.dtos.request.UpdateTaskRequest;
import app.dtos.response.TaskResponse;
import app.service.update_task.UpdateTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/to-do-app")
public class UpdateController {

    @Autowired
    private UpdateTaskServiceImpl updateTaskService;

    @PutMapping("/update")
    public TaskResponse update(@RequestBody UpdateTaskRequest updateTaskRequest) {
        return updateTaskService.updateTask(updateTaskRequest);
    }
}
