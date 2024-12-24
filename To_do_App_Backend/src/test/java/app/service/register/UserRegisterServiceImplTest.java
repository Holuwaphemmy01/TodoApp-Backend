package app.service.register;

import app.dtos.request.UserRegisterDto;
import app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRegisterServiceImplTest {

    @Autowired
    private UserRegisterServiceImpl userRegisterService;

    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testToThrowExceptionWhenAUserFirstNameIsNull() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName(" ");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        assertThrows(IllegalArgumentException.class, () ->userRegisterService.register(userRegisterDto));
    }

    @Test
    public void testToThrowExceptionWhenAUserLastNameIsBlankOrEmpty() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName(" ");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        assertThrows(IllegalArgumentException.class, () ->userRegisterService.register(userRegisterDto));
    }

    @Test
    public void testToThrowExceptionWhenAUserPsswordIsNullOrBlank() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword(" ");
        userRegisterDto.setUserName("user151515");
        assertThrows(IllegalArgumentException.class, () ->userRegisterService.register(userRegisterDto));
    }

    @Test
    public void testToThrowExceptionWhenAUserPasswordDoesNotBeginWithUppercase() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("password");
        userRegisterDto.setUserName("user151515");
        assertThrows(IllegalArgumentException.class, () ->userRegisterService.register(userRegisterDto));
    }

    @Test
    public void testToThrowExceptionWhenAUserUserNameIsBlankOrEmpty() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName(" ");
        assertThrows(IllegalArgumentException.class, () ->userRegisterService.register(userRegisterDto));
    }

    @Test
    public void testToThrowExceptionWhenAUserUserNameIsLessThan6Character() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user");
        assertThrows(IllegalArgumentException.class, () ->userRegisterService.register(userRegisterDto));
    }


    @Test
    public void testToRegisterAUserSuccess() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        userRegisterService.register(userRegisterDto);
    }

    @Test
    public void testToThrowExceptionWheSavedUserNameIsUsedToRegisterAgain() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("femi");
        userRegisterDto.setLastName("men");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("user151515");
        userRegisterService.register(userRegisterDto);
        UserRegisterDto userRegisterDto1 = new UserRegisterDto();
        userRegisterDto1.setFirstName("femi");
        userRegisterDto1.setLastName("men");
        userRegisterDto1.setPassword("Password");
        userRegisterDto1.setUserName("user151515");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.register(userRegisterDto1));
    }
}