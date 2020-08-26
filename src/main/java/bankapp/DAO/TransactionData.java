
package bankapp.DAO;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_txns",schema="BANKING")
public class TransactionData {
	
	@Id
	@Column(name="txn_id")
	private int txn_id;
	
	@OneToOne
	@JoinColumn(name="acc_id")
	private AccountData acc_id;
	
	private String  txn_type;
	
	private String txn_mode;
	
	private int txn_amount;
	
	
	public int getTxn_amount() {
		return txn_amount;
	}

	public void setTxn_amount(int txn_amount) {
		this.txn_amount = txn_amount;
	}

	private String txn_status;
	
	private Timestamp txn_time;

	public int getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(int txn_id) {
		this.txn_id = txn_id;
	}

	public AccountData getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(AccountData acc_id) {
		this.acc_id = acc_id;
	}

	public String getTxn_type() {
		return txn_type;
	}

	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}

	public String getTxn_mode() {
		return txn_mode;
	}

	public void setTxn_mode(String txn_mode) {
		this.txn_mode = txn_mode;
	}

	public String getTxn_status() {
		return txn_status;
	}

	public void setTxn_status(String txn_status) {
		this.txn_status = txn_status;
	}

	public Timestamp getTxn_time() {
		return txn_time;
	}

	public void setTxn_time(Timestamp txn_time) {
		this.txn_time = txn_time;
	}

	@Override
	public String toString() {
		return "TransactionData [txn_id=" + txn_id + ", acc_id=" + acc_id + ", txn_type=" + txn_type + ", txn_mode="
				+ txn_mode + ", txn_amount=" + txn_amount + ", txn_status=" + txn_status + ", txn_time=" + txn_time
				+ "]";
	}

	

}
