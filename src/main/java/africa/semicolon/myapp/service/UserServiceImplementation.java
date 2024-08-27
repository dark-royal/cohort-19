package africa.semicolon.myapp.service;

import africa.semicolon.myapp.data.models.User;
import africa.semicolon.myapp.data.repositories.UserRepository;
import africa.semicolon.myapp.dtos.request.LoginRequest;
import africa.semicolon.myapp.dtos.request.RegisterRequest;
import africa.semicolon.myapp.dtos.response.LoginResponse;
import africa.semicolon.myapp.dtos.response.RegisterResponse;
import africa.semicolon.myapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMessage("Registration Successful");
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws LoginException, UserNotFoundException {
        User user = userRepository.findByEmail(request.getEmail());
        if(user != null) {
            if(user.getPassword().equals(request.getPassword())) {
                user.setLoginStatus(true);
                userRepository.save(user);
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMessage("Login successful");
                return loginResponse;
            }
            else{
                throw new LoginException("Invalid email or password");
            }
        }
        else {
            throw new UserNotFoundException("User not found");
        }
    }
}
