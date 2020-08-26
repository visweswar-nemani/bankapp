package bankapp.api;

public class TransactionResponse {
	

	
	private String txn_status;
	
	private String description;

	

	public String getTxn_status() {
		return txn_status;
	}

	public void setTxn_status(String txn_status) {
		this.txn_status = txn_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TransactionResponse [txn_status=" + txn_status + ", description=" + description
				+ "]";
	}

}
