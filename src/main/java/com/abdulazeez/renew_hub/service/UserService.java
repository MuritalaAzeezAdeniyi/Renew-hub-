package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.LoginRequest;
import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse createUser(RegisterUserRequest request);
    String login(LoginRequest request);
}
