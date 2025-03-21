package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.LoginRequest;
import com.abdulazeez.renew_hub.dto.request.RegisterUserRequest;
import com.abdulazeez.renew_hub.dto.response.RegisterUserResponse;
import com.abdulazeez.renew_hub.exception.PhoneNumberException;
import com.abdulazeez.renew_hub.exception.RegisterSuccessFullException;
import com.abdulazeez.renew_hub.exception.UserAlreadyExitsException;
import com.abdulazeez.renew_hub.model.Users;
import com.abdulazeez.renew_hub.repositry.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
     private JWTService jwtService;
     private final ModelMapper  modelMapper;
     private final PasswordEncoder passwordEncoder;
     private final UserRepo userRepository;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepo userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse createUser(RegisterUserRequest request) throws RegisterSuccessFullException, PhoneNumberException {
        ValidateUserCredentials(request);
        validatePhoneNumber(request.getPhoneNumber());
        ValidateEmail(request.getEmail());
        Users user = modelMapper.map(request, Users.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
         user=userRepository.save(user);
        RegisterUserResponse response = modelMapper.map(user, RegisterUserResponse.class);
        response.setMessage("Successfully created user");
        return response;
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


    private void ValidateUserCredentials(RegisterUserRequest request) throws RegisterSuccessFullException {
        if(request.getUsername().trim().isEmpty() || request.getPassword().trim().isEmpty()
                || request.getEmail().trim().isEmpty() ||
                request.getFullName().trim().isEmpty()){
            throw new RegisterSuccessFullException("Credential improperly enter");
        }
    }

    private void validatePhoneNumber(String phoneNumber) throws PhoneNumberException {
        if(phoneNumber.length() != 11){
            throw new PhoneNumberException(" phone number must be 11 digits");
        }
    }

    private void ValidateEmail(String email) {
        Users user = userRepository.findByEmail(email);
        if(user != null){
            throw new UserAlreadyExitsException(String.format("User with email %s already exists", email));
        }
    }
}
