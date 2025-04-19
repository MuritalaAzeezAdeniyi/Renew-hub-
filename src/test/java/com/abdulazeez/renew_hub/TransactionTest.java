package com.abdulazeez.renew_hub;

import com.abdulazeez.renew_hub.dto.request.TransactionRequest;
import com.abdulazeez.renew_hub.dto.response.TransactionResponse;
import com.abdulazeez.renew_hub.service.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TransactionTest {
    @Autowired
    private TransactionServiceImpl transactionService;
    @Test
    public void testTransaction() {
        TransactionRequest request = new TransactionRequest();
        String email = "abdulazeez@gmail.com";
        request.setPropertyId(3L);
        TransactionResponse transactionResponse = transactionService.createTransaction(request,email);
        assertThat(transactionResponse).isNotNull();
        assertThat(transactionResponse.getMessage()).isEqualTo("Successfully created transaction");
    }


}
