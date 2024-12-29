package app.service.pending_task;

import app.dtos.response.TaskResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PendingTasksImplTest {

    @Autowired
    private PendingTasksImpl pendingTasks;

    @Test
    public void getAllPendingTasks() {
        List<Optional<TaskResponse>> result = pendingTasks.getAllPendingTasks("Femi1234");
        assertEquals(1, result.size());
    }
}