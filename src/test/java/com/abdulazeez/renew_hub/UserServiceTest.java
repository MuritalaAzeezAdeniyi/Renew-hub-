package com.abdulazeez.renew_hub;

import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;
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
    public void testThatUserCanBeCreated() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Abdulazeez");
        request.setFullName("Muritala Azeez");
        request.setPassword("1111");
        request.setEmail("abdulazeez@gmail.com");
        request.setPhoneNumber("1234567890");
        RegisterUserResponse response = userService.createUser(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).matches("Successfully Registered");

    }
}
