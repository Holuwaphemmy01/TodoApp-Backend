package app.service.login;

import app.dtos.request.UserLoginRequest;

public interface UserLoginService {
    String login(UserLoginRequest userLoginRequest);
}
