package bankapp.service;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankapp.PasswordHash;
import bankapp.SessionGenerator;
import bankapp.DAO.ILoginDAO;
import bankapp.api.BaseResponse.status;
import bankapp.api.BasicAccountInfo;
import bankapp.api.UserLoginRequest;
import bankapp.api.UserLoginResponse;

@Service
public class LoginService implements LoginServiceImplementation{

	private static Logger logger =LogManager.getLogger();
	
	@Autowired
	private ILoginDAO loginDAO;
	
	
	@Override
	public UserLoginResponse userLoginValidation(UserLoginRequest request ) {
		// TODO Auto-generated method stub
		UserLoginResponse response = new UserLoginResponse();
		logger.debug("the login details {}",request.toString());
		try {
			request.setPassword(new PasswordHash().passwordhash(request.getPassword()));
			response = loginDAO.validateUserLogin(request);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(status.FAILURE);
		}
		
		
		if(response.getStatus().equals(status.SUCCESS)) {
			response.setSessionKey(new SessionGenerator().generateSessionKey());
		}
		
		return response;
	}

	@Override
	public String agentLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public BasicAccountInfo getAccountinfo(String username) {
		return loginDAO.getBasicInfo(username);
	}

}
