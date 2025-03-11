package com.abdulazeez.renew_hub.repositry;

import com.abdulazeez.renew_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
