package bankapp.api;

import java.math.BigDecimal;

public class TransactionRequest {
	
	private int account_id;
	
	private String txn_type;
	
	private int amountEntered;
	
	private String username; 
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getTxn_type() {
		return txn_type;
	}

	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}

	public int getAmountEntered() {
		return amountEntered;
	}

	public void setAmountEntered(int amountEntered) {
		this.amountEntered = amountEntered;
	}

	@Override
	public String toString() {
		return "TransactionRequest [account_id=" + account_id + ", txn_type=" + txn_type + ", amountEntered="
				+ amountEntered + ", username=" + username + "]";
	}

	
}
