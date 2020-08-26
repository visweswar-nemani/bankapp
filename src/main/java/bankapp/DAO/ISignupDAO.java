package bankapp.DAO;

import bankapp.api.AccontCreationResponse;
import bankapp.api.CardCreationResponse;
import bankapp.api.SignupResponse;

public interface ISignupDAO {
	
	public SignupData saveUserProfile(SignupData signupData);
	
	public AccontCreationResponse createAccount(AccountData accountData);
	
	

	public int getProfileIdByEmail(String email);
	
	public boolean checkAccountNumber(int acc_number);
	
	public CardCreationResponse IssueNewCard(CardData request);
	
	

}
