package bankapp.DAO;

import bankapp.api.TransactionRequest;
import bankapp.api.TransactionResponse;

public interface ITransactionDAO {
	
	public TransactionResponse doDeposit(TransactionRequest request);
	
	public TransactionResponse doWithdraw(TransactionRequest request);
	
	

}
