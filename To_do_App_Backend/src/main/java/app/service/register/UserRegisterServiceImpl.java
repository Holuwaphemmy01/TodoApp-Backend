package app.service.register;

import app.dtos.request.UserRegisterDto;
import app.model.User;
import app.repository.UserRepository;
import app.service.password.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HashPassword hashPassword;

    @Override
    public String register(UserRegisterDto userRegisterDto) {
        if(userRegisterDto.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        if(userRegisterDto.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be blank");
        if(userRegisterDto.getUserName().isBlank()) throw new IllegalArgumentException("Username cannot be blank");
        if(userRegisterDto.getUserName().length() < 6) throw new IllegalArgumentException("Username must be at least 6 characters");
        if(userRepository.existsById(userRegisterDto.getUserName())) throw new IllegalArgumentException("Username already exists");
        if(userRegisterDto.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be blank");
        if(!Character.isUpperCase(userRegisterDto.getPassword().charAt(0))) throw new IllegalArgumentException("Password must start with Capital letter");
        if(userRegisterDto.getPassword().length() < 6) throw new IllegalArgumentException("Password must be at least 6 characters");

        User user = new User();
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setUsername(userRegisterDto.getUserName());
        user.setPassword(hashPassword.hash(userRegisterDto.getPassword()));
        userRepository.save(user);
        return "Registered Successfully";
    }
}
