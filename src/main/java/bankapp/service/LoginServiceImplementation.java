package bankapp.service;

import bankapp.api.BasicAccountInfo;
import bankapp.api.UserLoginRequest;
import bankapp.api.UserLoginResponse;

public interface LoginServiceImplementation {
	
	public UserLoginResponse userLoginValidation(UserLoginRequest request);
	
	public String agentLogin();
	
	public BasicAccountInfo getAccountinfo(String username);

}
