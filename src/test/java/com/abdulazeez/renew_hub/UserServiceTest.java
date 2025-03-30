package com.abdulazeez.renew_hub;

import com.abdulazeez.renew_hub.dto.request.LoginRequest;
import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.LoginResponse;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;
import com.abdulazeez.renew_hub.exception.PhoneNumberException;
import com.abdulazeez.renew_hub.exception.RegisterSuccessFullException;
import com.abdulazeez.renew_hub.model.Role;
import com.abdulazeez.renew_hub.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void testThatUserCanBeCreated() throws RegisterSuccessFullException, PhoneNumberException {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("abdul");
        request.setFullName("Muritala Azeez");
        request.setPassword("1111");
        request.setEmail("aze@gmail.com");
        request.setPhoneNumber("12345678901");
        request.setRole(Role.SELLER);
        RegisterUserResponse response = userService.createUser(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).matches("Successfully created user");

    }
    @Test
    public void testThatUserCanLogin() throws PhoneNumberException, RegisterSuccessFullException {
        LoginRequest request = new LoginRequest();
        request.setUsername("Abdulazeez");
        request.setPassword("1111");
        String response = userService.login(request);
        System.out.println(response);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatUserCanRegister() throws PhoneNumberException, RegisterSuccessFullException {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Abdulazeez");
        request.setFullName("MuritalaAzeez");
        request.setPassword("4545");
        request.setPhoneNumber("78087654328");
        request.setEmail("Wura@gmail.com");
        request.setRole(Role.BUYER);
        RegisterUserResponse response = userService.createUser(request);
        assertThat(response).isNotNull();

    }

}
