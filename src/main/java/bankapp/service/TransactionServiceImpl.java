package bankapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankapp.DAO.ITransactionDAO;
import bankapp.api.BaseResponse.status;
import bankapp.api.TransactionRequest;
import bankapp.api.TransactionResponse;

@Service
public class TransactionServiceImpl implements ITransactionService{

	
	private static Logger logger = LogManager.getLogger();
	
	
	@Autowired
	private ITransactionDAO  transactionDAO;
	
	@Override
	public TransactionResponse doTransaction(TransactionRequest request) {
		TransactionResponse response =  new TransactionResponse();
		try {			
		
		if(request.getTxn_type().equalsIgnoreCase("deposit") && request.getAmountEntered()<=1000000) {
			response =  transactionDAO.doDeposit(request);
		}else if(request.getTxn_type().equalsIgnoreCase("withdraw") && request.getAmountEntered()<=1000000) {
			response = transactionDAO.doWithdraw(request);
		}else {			
			response.setTxn_status(status.FAILURE.toString());	
			response.setDescription("limit exceeded");
		}
		
		} catch(Exception e ) {
			logger.error("failed in processing transaction --{}",e);
			response.setTxn_status(status.FAILURE.toString());
			response.setDescription("txn_failed");
		}
		return response;
		
		// TODO Auto-generated method stub
		
	}

}
