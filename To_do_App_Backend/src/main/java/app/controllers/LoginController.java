package app.controllers;

import app.dtos.request.UserLoginRequest;
import app.service.login.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/to-do-app")
public class LoginController {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            return userLoginService.login(userLoginRequest);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
