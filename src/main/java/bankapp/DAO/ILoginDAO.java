package bankapp.DAO;

import bankapp.api.BasicAccountInfo;
import bankapp.api.UserLoginRequest;
import bankapp.api.UserLoginResponse;

public interface ILoginDAO {
	
	public UserLoginResponse validateUserLogin(UserLoginRequest request);
	
	public String validateAgentLogin();
	
	public BasicAccountInfo getBasicInfo(String username );
}
