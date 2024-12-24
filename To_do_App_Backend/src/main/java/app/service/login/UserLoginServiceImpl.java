package app.service.login;

import app.dtos.request.UserLoginRequest;
import app.model.User;
import app.repository.UserRepository;
import app.service.password.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HashPassword hashPassword;

    @Override
    public String login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByUsername(userLoginRequest.getUsername());
        if(user == null) throw new IllegalArgumentException("User not found");
        if(!hashPassword.checkPassword(userLoginRequest.getPassword(), user.getPassword())) throw new IllegalArgumentException("Wrong password");
        return user.getUsername() + " logged in successfully" ;
    }
}
