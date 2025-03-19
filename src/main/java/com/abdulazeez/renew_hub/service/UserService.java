package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.LoginRequest;
import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;
import com.abdulazeez.renew_hub.exception.PhoneNumberException;
import com.abdulazeez.renew_hub.exception.RegisterSuccessFullException;

public interface UserService {

    RegisterUserResponse createUser(RegisterUserRequest request) throws RegisterSuccessFullException, PhoneNumberException;
    String login(LoginRequest request);
}
