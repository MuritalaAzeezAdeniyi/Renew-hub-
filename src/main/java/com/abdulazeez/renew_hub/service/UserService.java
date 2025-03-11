package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse createUser(RegisterUserRequest request);
}
