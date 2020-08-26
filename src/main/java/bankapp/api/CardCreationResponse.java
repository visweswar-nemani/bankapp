package bankapp.api;

import bankapp.api.BaseResponse.status;

public class CardCreationResponse extends BaseResponse{
	
	
	
	private int card_id;
	private String card_status;
	
	public  status status;
	
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int debit_card) {
		this.card_id = debit_card;
	}
	public String getCard_status() {
		return card_status;
	}
	public void setCard_status(String card_status) {
		this.card_status = card_status;
	}
	@Override
	public String toString() {
		return "CardCreationResponse [card_id=" + card_id + ", card_status=" + card_status + ", status=" + status + "]";
	}
	

}
