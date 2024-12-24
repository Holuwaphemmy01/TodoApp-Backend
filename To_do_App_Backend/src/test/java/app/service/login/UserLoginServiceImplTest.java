package app.service.login;

import app.dtos.request.UserLoginRequest;
import app.dtos.request.UserRegisterDto;
import app.repository.UserRepository;
import app.service.register.UserRegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLoginServiceImplTest {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testToRegisterUserAndUserLoginSuccessfully(){
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        userRegisterService.register(userRegisterDto);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("user151515");
        userLoginRequest.setPassword("Password");
        assertEquals(userLoginRequest.getUsername()+ " logged in successfully", userLoginService.login(userLoginRequest));
    }

}