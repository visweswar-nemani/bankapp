package bankapp.DAO;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bankapp.api.AmountConversion;
import bankapp.api.BasicAccountInfo;
import bankapp.api.BaseResponse.status;
import bankapp.api.TransactionDescription;
import bankapp.api.TransactionRequest;
import bankapp.api.TransactionResponse;
import bankapp.api.UserLoginResponse;

@Repository
public class TransactionDAO implements ITransactionDAO{
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<AccountData>  getBalance (TransactionRequest request) {
		Query query;
		List<AccountData> result;
		int current_bal=-1;
		// TODO Auto-generated method stub
		String sql = "select a  from AccountData a where a.acc_id =:in_account_id";
		query = sessionFactory.getCurrentSession().createQuery(sql, AccountData.class);
		query.setParameter("in_account_id", request.getAccount_id());
		result=query.getResultList();
		
		return result;
	}


	@Transactional
	@Override
	public TransactionResponse doWithdraw(TransactionRequest request) {
		// TODO Auto-generated method stub
		logger.info("details given for withdrawl -->{}",request);
		TransactionResponse response = new TransactionResponse();
		AccountData acc_data = getBalance(request).get(0);
		TransactionData data = new TransactionData();
		Query query;
		int current_bal = acc_data.getAcc_balance();
		if(current_bal<=0) {
			response.setTxn_status(status.FAILURE.toString());
			response.setDescription(TransactionDescription.no_balance.toString());
			return response;
		}
		if(current_bal >0 && current_bal < request.getAmountEntered()) {
			response.setTxn_status(status.FAILURE.toString());
			response.setDescription(TransactionDescription.no_enough_balance.toString());
			return response;
		}
		data.setAcc_id(acc_data);
		data.setTxn_id((int) System.currentTimeMillis());
		data.setTxn_mode("CASH");
		data.setTxn_status(TransactionDescription.txn_success.toString());
		data.setTxn_time(new Timestamp(System.currentTimeMillis()));
		data.setTxn_type(request.getTxn_type());
		data.setTxn_amount(request.getAmountEntered());
		
		sessionFactory.getCurrentSession().save(data);
		
		String updateBalance = "UPDATE  AccountData a SET a.acc_balance = :new_balance where a.acc_id = :in_account_id";
		 sessionFactory.getCurrentSession().createQuery(updateBalance)
		.setParameter("in_account_id", request.getAccount_id())
		.setParameter("new_balance", (current_bal-request.getAmountEntered())).executeUpdate();
		 
		response.setTxn_status(status.SUCCESS.toString());
		response.setDescription(TransactionDescription.txn_success.toString());
		logger.info("after withdrawl -->{}",response);
		return response;
	}

	
	@SuppressWarnings({ "rawtypes"})
	@Transactional
	@Override
	public TransactionResponse doDeposit(TransactionRequest request) {
		// TODO Auto-generated method stub
		logger.info("details given for deposit -->{}",request);
		TransactionResponse response = new TransactionResponse();
		TransactionData data = new TransactionData();
		Query query;
		AccountData acc_data = getBalance(request).get(0);
		int current_bal = acc_data.getAcc_balance();
		
		if(current_bal >=0) {
			data.setAcc_id(acc_data);
			data.setTxn_id((int) System.currentTimeMillis());
			data.setTxn_mode("CASH");
			data.setTxn_status(TransactionDescription.txn_success.toString());
			data.setTxn_time(new Timestamp(System.currentTimeMillis()));
			data.setTxn_type(request.getTxn_type());
			data.setTxn_amount(request.getAmountEntered());
			
			sessionFactory.getCurrentSession().save(data);
		
		
		String updateBalance = "UPDATE  AccountData a SET a.acc_balance = :new_balance where a.acc_id = :in_account_id";
		sessionFactory.getCurrentSession().createQuery(updateBalance)
		.setParameter("in_account_id", request.getAccount_id())
		.setParameter("new_balance", (current_bal+request.getAmountEntered())).executeUpdate();
		

		response.setTxn_status(status.SUCCESS.toString());
		response.setDescription(TransactionDescription.txn_success.toString());
		
		}else {
			response.setTxn_status(status.FAILURE.toString());
			response.setDescription(TransactionDescription.txn_failed.toString());			
		}
		logger.info("after deposit -->{}",response);
		return response;
	}
	
	
	
	public BasicAccountInfo getBasicInfo(int account_id) {
		BasicAccountInfo info = new BasicAccountInfo();
		String sql="select p.first_name ,p.last_name,a.acc_id,a.acc_type,a.acc_balance,p.username,a.debit_card,a.card_status from SignupData p JOIN AccountData a ON p.profile_id=a.signupData where a.acc_id=:account_id";
		Query query ;
		List< Object[] > result= null;;
		
		try {
			query= sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("account_id", account_id);
			result = query.list();
			if(result.size()<=0) {
				logger.debug("Authentication failed ");
				
				return null;
			}
			for(Object[] res: result ) {	
				
				info.setFirstname(res[0].toString());
				info.setLastname(res[1].toString());
				info.setAcc_id(res[2].toString());
				info.setAcc_type(res[3].toString());
				info.setAcc_bal(res[4].toString());
				info.setUsername(res[5].toString());
				info.setCard_id(res[6].toString());
				info.setCard_status(res[7].toString());
				
			}
			
		}catch(Exception e) {
			logger.error("error at validating user --> {}",e);
			return null;
		}
		
		// TODO Auto-generated method stub
		return info;
	}

}
