package bankapp.api;

import bankapp.DAO.SignupData;

public class AccountCreateRequest {
	
	
	
	private SignupData profile_id;
	
	private String account_type;

	public SignupData getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(SignupData profile_id) {
		this.profile_id = profile_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
			this.account_type = account_type;
		
		
	}

	@Override
	public String toString() {
		return "AccountCreateRequest [profile_id=" + profile_id + ", account_type=" + account_type + "]";
	}
	
	
	
	

}
