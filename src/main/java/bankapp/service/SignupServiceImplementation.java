package bankapp.service;


import bankapp.api.AccontCreationResponse;
import bankapp.api.AccountCreateRequest;
import bankapp.api.SignupResponse;
import bankapp.api.userSignupInfo;

public interface SignupServiceImplementation {
	
	public SignupResponse  userSignup(userSignupInfo userSignupInfo) ;
	
	public AccontCreationResponse  createUserAccount(AccountCreateRequest request);

}
