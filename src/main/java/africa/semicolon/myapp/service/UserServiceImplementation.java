package africa.semicolon.myapp.service;

import africa.semicolon.myapp.data.models.User;
import africa.semicolon.myapp.data.repositories.UserRepository;
import africa.semicolon.myapp.dtos.request.RegisterRequest;
import africa.semicolon.myapp.dtos.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

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
}
