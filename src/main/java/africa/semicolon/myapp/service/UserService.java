package africa.semicolon.myapp.service;

import africa.semicolon.myapp.dtos.request.RegisterRequest;
import africa.semicolon.myapp.dtos.response.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);
}
