package app.controllers;

import app.dtos.request.UserRegisterDto;
import app.service.register.UserRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/to-do-app")
public class RegisterController {

    @Autowired
    private UserRegisterServiceImpl userRegisterService;

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        try{
            return userRegisterService.register(userRegisterDto);

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
