package com.abdulazeez.renew_hub.repositry;

import com.abdulazeez.renew_hub.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
