package bankapp.api;

import bankapp.DAO.AccountData;

public class CardCreateRequest {
	

	private AccountData account_number;
	
	private AccountData account_type;

	public AccountData getAccount_number() {
		return account_number;
	}

	public void setAccount_number(AccountData account_number) {
		this.account_number = account_number;
	}

	public AccountData getAccount_type() {
		return account_type;
	}

	public void setAccount_type(AccountData account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "DebitCardCreateRequest [account_number=" + account_number + ", account_type=" + account_type + "]";
	}
	
	
	

}
