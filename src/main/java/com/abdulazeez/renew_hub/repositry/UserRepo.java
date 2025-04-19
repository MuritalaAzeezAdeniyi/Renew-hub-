package com.abdulazeez.renew_hub.repositry;

import com.abdulazeez.renew_hub.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
   Optional  <Users> findByEmail(String email);
}
