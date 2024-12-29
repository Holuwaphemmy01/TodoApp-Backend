package app.controllers;

import app.dtos.request.DeleteTaskRequest;
import app.repository.TaskRepository;
import app.service.delete_task.DeleteTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/to-do-app")
public class DeleteTaskController {

    @Autowired
    private DeleteTaskService deleteTaskService;

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete")
    public String deleteTask(@RequestBody DeleteTaskRequest deleteTaskRequest) {
        try {
            deleteTaskService.deleteTask(deleteTaskRequest);
            return "Task deleted successfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
