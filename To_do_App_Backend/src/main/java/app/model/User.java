package app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private String firstName;
    private String lastName;
    @Id
    private String username;
    private String password;
}
