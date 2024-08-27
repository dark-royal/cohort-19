package africa.semicolon.myapp.service;

import africa.semicolon.myapp.dtos.request.RegisterRequest;
import africa.semicolon.myapp.dtos.response.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {

        RegisterRequest request = new RegisterRequest();
        request.setUsername("praise");
        request.setEmail("praise@gmail.com");
        request.setPassword("praise123");
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Registration Successful");
        assertThat(response.getMessage()).contains("Registration Successful");
        assertThat(response.getMessage()).contains("Registration Successful");

    }

    @Test
    public void testLoginUser() throws UserNotFoundException, LoginException {
        testRegisterUser();
        LoginRequest request = new LoginRequest();
        request.setEmail("praise@gmail.com");
        request.setPassword("praise123");
        LoginResponse response = userService.login(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Login successful");

    }

}
