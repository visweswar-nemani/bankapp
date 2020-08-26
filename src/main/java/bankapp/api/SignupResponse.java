package bankapp.api;

import bankapp.api.BaseResponse.status;

public class SignupResponse extends BaseResponse{
	
	
	private String first_name;
	private String last_name;
	private int acc_number;
	private int acc_balance;
	private String acc_type;
	private boolean accountCreated;
	private status status;
	
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(int acc_number) {
		this.acc_number = acc_number;
	}
	public int getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(int acc_balance) {
		this.acc_balance = acc_balance;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}
	public boolean getAccountCreated() {
		return this.accountCreated;
	}
	public void setAccountCreated(boolean accountCreated) {
		this.accountCreated = accountCreated;
	}
	
	
	
	@Override
	public String toString() {
		return "SignupResponse [first_name=" + first_name + ", last_name=" + last_name + ", acc_number=" + acc_number
				+ ", acc_balance=" + acc_balance + ", acc_type=" + acc_type + ", accountCreated=" + accountCreated
				+ ", status=" + status + "]";
	}
	
	
	
}
