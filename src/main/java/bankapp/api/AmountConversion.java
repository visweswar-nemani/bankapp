package bankapp.api;



public class AmountConversion {
	
	

	
	
	public int convertToPaisa(int txn_amount) {
		
		return txn_amount*100;
		
	}
	

	public int convertToRupee(int txn_amount) {
		return (txn_amount/100);
	}
}
