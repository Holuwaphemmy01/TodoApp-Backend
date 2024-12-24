package app;

import app.dtos.response.TaskResponse;
import app.service.view_all_task.ViewAllTasksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringBootApplication(scanBasePackages = "app")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}
