package app.repository;

import app.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {


    List<Task> findAllByUserId(String userId);

    Task findTasksByTaskIdAndUserId(String taskId, String userId);

    Task findTasksByUserId(String userId);

    List<Task> findAllByUserIdIgnoreCase(String lowerCase);
}
