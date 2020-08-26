package bankapp.DAO;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class CardDataLog {


	@OneToOne
	@JoinColumn(name = "card_id")
	private CardData card_id;
	
	@OneToOne
	@JoinColumn(name = "acc_id")
	private AccountData acc_id;
	
	private String card_type;
	
	private int cvv;
	
	private String card_status;
	
	private Timestamp validity;
	
	private Timestamp createdTime;
	
	private Timestamp updatedTime;

	public CardData getCard_id() {
		return card_id;
	}

	public void setCard_id(CardData card_id) {
		this.card_id = card_id;
	}

	public AccountData getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(AccountData acc_id) {
		this.acc_id = acc_id;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCard_status() {
		return card_status;
	}

	public void setCard_status(String card_status) {
		this.card_status = card_status;
	}

	public Timestamp getValidity() {
		return validity;
	}

	public void setValidity(Timestamp validity) {
		this.validity = validity;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "CardDataLog [card_id=" + card_id + ", acc_id=" + acc_id + ", card_type=" + card_type + ", cvv=" + cvv
				+ ", card_status=" + card_status + ", validity=" + validity + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + "]";
	}
	
	
	
}
