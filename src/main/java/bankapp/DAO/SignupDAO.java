package bankapp.DAO;



import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;

import bankapp.api.AccontCreationResponse;
import bankapp.api.BaseResponse.status;
import bankapp.api.CardCreationResponse;
import bankapp.api.SignupResponse;
import bankapp.api.userSignupInfo;

@Repository
public class SignupDAO implements ISignupDAO{
	
	private static Logger logger = LogManager.getLogger(SignupDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public SignupData saveUserProfile(SignupData signupData) {
		// TODO Auto-generated method stub
		//SignupResponse signupResponse = new SignupResponse();
		/*
		 * Session session=sessionFactory.openSession(); Transaction tx= null; try { tx
		 * = session.beginTransaction(); session.save(signupData); tx.commit();
		 * signupResponse.setStatus(status.SUCCESS); }catch(Exception e) {
		 * logger.error("profile not created --> {} ", e);
		 * signupResponse.setStatus(status.FAILURE); if(tx!=null) { tx.rollback(); }
		 * 
		 * }finally { session.close(); }
		 * 
		 * return signupResponse;
		 */
		try {
			sessionFactory.getCurrentSession().save(signupData);
			
			//signupResponse.setStatus(status.SUCCESS);
			
		} catch(Exception e) {
			logger.error("profile not created --> {} ", e);
			return null;
		}
		return signupData;
	}

	
	@Transactional
	@Override
	public AccontCreationResponse createAccount(AccountData accountData) {
		// TODO Auto-generated method stub
		AccontCreationResponse response = new AccontCreationResponse();
		try {
			sessionFactory.getCurrentSession().save(accountData);
			response.setAcc_number(accountData.getAcc_id());
			response.setAcc_balance(accountData.getAcc_balance());
			response.setAcc_type(accountData.getAcc_type());
			response.setStatus(status.SUCCESS);
		} catch (Exception e) {
			logger.error("error in creating an account -->{}",e);
			response.setStatus(status.FAILURE);
		}
		
		return response;
	}
	
	
	@Transactional
	@Override
		public int getProfileIdByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select p.profile_id from SignupData p where p.email =:email";
		List <Integer> result = null;
		Query query= null;
		try {
			query = sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("email", email);
			result = query.list();
			
			logger.info(" the profile id is --->{}", result.get(0).toString());
		} catch(Exception e) {
			logger.error("exception in getting profile ID ---> {}",e);
		}
		
			
		return result.get(0);	
	}

	@Override
	public boolean checkAccountNumber(int acc_number) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public CardCreationResponse IssueNewCard(CardData request) {
		logger.info("Saving new card details {}",request);
		CardCreationResponse response = new CardCreationResponse();
		sessionFactory.getCurrentSession().save(request);
		
		
		response.setCard_id(request.getCard_id());
		response.setCard_status(request.getCard_status());
		
		
		
		String updateAccountQuery = "update AccountData a set a.debit_card=:card_id,a.card_status=:card_status,a.acc_updated_time=:update_time where a.acc_id =:account_id";
		sessionFactory.getCurrentSession().createQuery(updateAccountQuery)
		.setInteger("card_id", request.getCard_id())
		.setString("card_status", request.getCard_status().toString())
		.setTimestamp("update_time",new Timestamp(System.currentTimeMillis()))
		.setEntity("account_id", request.getAcc_id()).executeUpdate();
		
		
		
		response.setStatus(status.SUCCESS);
		return response;
	}
	
	
		
}
