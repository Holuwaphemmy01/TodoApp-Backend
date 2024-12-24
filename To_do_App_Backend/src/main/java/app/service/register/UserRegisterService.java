package app.service.register;

import app.dtos.request.UserRegisterDto;

public interface UserRegisterService {
    String register(UserRegisterDto userRegisterDto);
}
