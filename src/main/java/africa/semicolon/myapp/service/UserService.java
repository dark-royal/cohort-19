package africa.semicolon.myapp.service;

import africa.semicolon.myapp.dtos.request.LoginRequest;
import africa.semicolon.myapp.dtos.request.RegisterRequest;
import africa.semicolon.myapp.dtos.response.LoginResponse;
import africa.semicolon.myapp.dtos.response.RegisterResponse;
import africa.semicolon.myapp.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest request) throws LoginException, UserNotFoundException;

}
