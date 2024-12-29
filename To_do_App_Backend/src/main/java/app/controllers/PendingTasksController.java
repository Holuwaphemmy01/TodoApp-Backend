package app.controllers;

import app.dtos.response.TaskResponse;
import app.service.pending_task.PendingTasksImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/to-do-app")
@RestController
public class PendingTasksController {

    @Autowired
    private PendingTasksImpl pendingTasks;


    @GetMapping("/pendingtasks/{username}")
    public ResponseEntity<?> completedTasks(@PathVariable("username") String username) {

        try {
            List<Optional<TaskResponse>> listOfTask = pendingTasks.getAllPendingTasks(username);
            if(listOfTask.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                return new ResponseEntity<>(listOfTask, HttpStatus.OK);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
