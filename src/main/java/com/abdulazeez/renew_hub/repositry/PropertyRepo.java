package com.abdulazeez.renew_hub.repositry;

import com.abdulazeez.renew_hub.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepo extends JpaRepository<Property, Long> {
//     Optional<Property> findById(Long id);
}
