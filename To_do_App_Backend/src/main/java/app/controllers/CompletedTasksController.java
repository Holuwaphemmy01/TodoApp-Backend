package app.controllers;

import app.dtos.response.TaskResponse;
import app.service.completed_task.CompletedTasksImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/to-do-app")
public class CompletedTasksController {

    @Autowired
    private CompletedTasksImpl completedTasksImpl;

    @CrossOrigin(origins = "*")
    @GetMapping("/completedtasks/{username}")
    public ResponseEntity<?> completedTasks(@PathVariable("username") String username) {

        try {
            List<Optional<TaskResponse>> listOfTask = completedTasksImpl.getCompletedTasks(username);
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




