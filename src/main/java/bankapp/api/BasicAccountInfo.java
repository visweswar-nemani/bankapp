package bankapp.api;

public class BasicAccountInfo {
	
private String  firstname;
	
	private String lastname;	
	
	private String acc_id;
	
	private String acc_type;
	
	private String acc_bal;
	
	private String username;
	
	private String card_id;
	
	private String card_status;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAcc_bal() {
		return acc_bal;
	}

	public void setAcc_bal(String acc_bal) {
		this.acc_bal = acc_bal;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getCard_status() {
		return card_status;
	}

	public void setCard_status(String card_status) {
		this.card_status = card_status;
	}

	@Override
	public String toString() {
		return "UserAccountInfo [firstname=" + firstname + ", lastname=" + lastname + ", acc_id=" + acc_id
				+ ", acc_type=" + acc_type + ", acc_bal=" + acc_bal + ", username=" + username + ", card_id=" + card_id
				+ ", card_status=" + card_status + "]";
	}
	
	
}
