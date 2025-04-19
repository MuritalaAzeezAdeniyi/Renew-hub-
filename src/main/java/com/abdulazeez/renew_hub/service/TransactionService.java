package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.TransactionRequest;
import com.abdulazeez.renew_hub.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest transactionRequest, String userName);

}
