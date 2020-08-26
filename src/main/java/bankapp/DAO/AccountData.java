package bankapp.DAO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_user_account" , schema="banking")
public class AccountData {
	
	@Id
	private int acc_id;
	
	private String acc_type;
	
	@OneToOne
	@JoinColumn(name = "profile_id")
	private SignupData signupData;
	
	private int acc_balance;
	
	private int debit_card;   //need to change to card and add card type  
	
	
	
	@Column(nullable = false, insertable = true)
	private String card_status;
	
	@Column(nullable = false, insertable = true)
	private Timestamp acc_created_time;
	
	@Column(nullable = false, insertable = true)
	private Timestamp acc_updated_time;

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public SignupData getSignupData() {
		return signupData;
	}

	public void setSignupData(SignupData i) {
		this.signupData = i;
	}

	public int getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(int acc_balance) {
		this.acc_balance = acc_balance;
	}

	public int getDebit_card() {
		return debit_card;
	}

	public void setDebit_card(int debit_card) {
		this.debit_card = debit_card;
	}

	public String getCard_status() {
		return card_status;
	}
	
	
	public void setCard_status(String card_status) {
		this.card_status = card_status;
	}

	public Timestamp getAcc_created_time() {
		return acc_created_time;
	}

	public void setAcc_created_time(Timestamp acc_created_time) {
		this.acc_created_time = acc_created_time;
	}

	public Timestamp getAcc_updated_time() {
		return acc_updated_time;
	}

	public void setAcc_updated_time(Timestamp acc_updated_time) {
		this.acc_updated_time = acc_updated_time;
	}

	@Override
	public String toString() {
		return "AccountData [acc_id=" + acc_id + ", acc_type=" + acc_type + ", profile_id=" + signupData
				+ ", acc_balance=" + acc_balance + ", debit_card=" + debit_card + ", card_status=" + card_status
				+ ", acc_created_time=" + acc_created_time + ", acc_updated_time=" + acc_updated_time + "]";
	}
	
}
