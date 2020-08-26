package bankapp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bankapp.api.BaseResponse.status;
import bankapp.api.BasicAccountInfo;
import bankapp.api.UserLoginRequest;
import bankapp.api.UserLoginResponse;

@Repository
public class LoginDAO implements ILoginDAO {
	
	private static Logger logger = LogManager.getLogger(LoginDAO.class); 

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public UserLoginResponse validateUserLogin(UserLoginRequest request) {
		UserLoginResponse response =  new UserLoginResponse();
		BasicAccountInfo info = new BasicAccountInfo();
		String sql="select p.username from SignupData p  where p.username=:username and p.password=:password ";
		Query query ;
		List< String > result= null;
		
		try {
			query= sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("username", request.getUsername());
			query.setParameter("password", request.getPassword());
			result = query.list();
			if(result.size()<=0) {
				logger.debug("Authentication failed");
				response.setStatus(status.FAILURE);
				return response;
			}
			for( int i = 0; i<result.size();i++ ) {	
				
				response.setUsername(result.get(0));
				response.setStatus(status.SUCCESS);
			}
			
		}catch(Exception e) {
			logger.error("error at validating user --> {}",e);
			response.setStatus(status.FAILURE);
		}
		
		// TODO Auto-generated method stub
		return response;
	}


	@Override
	public String validateAgentLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public BasicAccountInfo getBasicInfo(String username ) {
		BasicAccountInfo info = new BasicAccountInfo();
		String sql="select p.first_name ,p.last_name,a.acc_id,a.acc_type,a.acc_balance,p.username,a.debit_card,a.card_status from SignupData p JOIN AccountData a ON p.profile_id=a.signupData where p.username=:username";
		Query query ;
		List< Object[] > result= null;;
		
		try {
			query= sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("username", username);
			result = query.list();
			if(result.size()<=0) {
				logger.debug("Authentication username ");
				
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
