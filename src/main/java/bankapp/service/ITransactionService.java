package bankapp.service;

import bankapp.api.TransactionRequest;
import bankapp.api.TransactionResponse;

public interface ITransactionService {
	
	public TransactionResponse doTransaction(TransactionRequest request);

}
