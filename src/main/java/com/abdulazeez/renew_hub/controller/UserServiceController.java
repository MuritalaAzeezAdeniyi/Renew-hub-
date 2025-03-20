package com.abdulazeez.renew_hub.controller;

import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.ApiResponse;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;
import com.abdulazeez.renew_hub.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {
    private final UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity <?> RegisterUser(@RequestBody RegisterUserRequest registerUserRequest) {
        try{
            RegisterUserResponse response = userService.createUser(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,response), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
