package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.LoginRequest;
import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
     private JWTService jwtService;

     @Override
    public RegisterUserResponse createUser(RegisterUserRequest request){
        return null;
    }

    @Override
    public String login(LoginRequest request) {
        Authentication  authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
                 if(authentication.isAuthenticated()){
                     return jwtService.generateToken(request.getUsername());
                 }
        return null;
    }
}
