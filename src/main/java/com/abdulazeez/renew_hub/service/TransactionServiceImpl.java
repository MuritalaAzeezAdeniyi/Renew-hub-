package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.TransactionRequest;
import com.abdulazeez.renew_hub.dto.response.TransactionResponse;
import com.abdulazeez.renew_hub.model.Property;
import com.abdulazeez.renew_hub.model.Transaction;
import com.abdulazeez.renew_hub.model.Users;
import com.abdulazeez.renew_hub.repositry.PropertyRepo;
import com.abdulazeez.renew_hub.repositry.TransactionRepo;
import com.abdulazeez.renew_hub.repositry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private PropertyRepo propertyRepository;
    @Autowired
    private TransactionRepo transactionRepository;
    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest,String userName) {

        Property property = propertyRepository.findById(transactionRequest.getPropertyId())
                .orElseThrow(()-> new RuntimeException("Property not found"));

        Users buyer = userRepository.findByEmail(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Users seller = property.getSeller();

         Transaction transaction = new Transaction();
         transaction.setBuyer(buyer);
         transaction.setSeller(seller);
         transaction.setTransactionDate(LocalDate.now());
         transaction.setSalePrice(property.getPrice());
         transaction.setProperty(property);
         transactionRepository.save(transaction);
         userRepository.save(buyer);
         userRepository.save(seller);
         propertyRepository.save(property);

        TransactionResponse response = new TransactionResponse();
        response.setAmount(transactionRequest.getSalePrice());
        response.setSeller(seller);
        response.setBuyer(buyer);
        response.setMessage("Successfully created transaction");
        return response;
    }
}
