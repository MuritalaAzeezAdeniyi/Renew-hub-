package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.model.UserPrinciple;
import com.abdulazeez.renew_hub.model.Users;
import com.abdulazeez.renew_hub.repositry.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    private UserRepo userRepo;
    public MyUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(username);
        if(users == null){

            throw new UsernameNotFoundException("User not found"+ username);
        }
        return new UserPrinciple(users);
    }
}
