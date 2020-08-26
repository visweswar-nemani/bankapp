package bankapp.api;

public class AccontCreationResponse extends BaseResponse{
	
	private int acc_number;
	private int acc_balance;
	private String acc_type;
	private status status;
	
	
	
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
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
	
	
	
	@Override
	public String toString() {
		return "AccontCreationResponse [acc_number=" + acc_number + ", acc_balance=" + acc_balance + ", acc_type="
				+ acc_type + ", status=" + status + "]";
	}
	
	
	
	
}
