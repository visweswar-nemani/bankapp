package bankapp.DAO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_card_details",schema = "banking")

public class CardData {
	
	@Id
	@Column(name = "card_id")
	private int card_id;
	
	@OneToOne
	@JoinColumn(name = "acc_id")
	private AccountData acc_id;
	
	private String card_type;  //VISA,MASTER,...
	
	private int cvv;
	
	private String card_status;
	
	
	private Timestamp validity;
	
	private Timestamp created_time;
	
	private Timestamp updated_time;

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
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

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

	public Timestamp getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}

	@Override
	public String toString() {
		return "CardData [card_id=" + card_id + ", acc_id=" + acc_id + ", card_type=" + card_type + ", cvv=" + cvv
				+ ", card_status=" + card_status + ", validity=" + validity + ", created_time=" + created_time
				+ ", updated_time=" + updated_time + "]";
	}
	

}
