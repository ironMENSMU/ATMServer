package model;

public class TransactionRequestDAO {

	public TransactionRequestDAO(){}
	
	public TransactionRequest createTransactionRequest(String transactionId, String customerId, String accountNum,
			double amount, String currency, String transactionType){
		
		TransactionRequest transactionRequest = new TransactionRequest(transactionId, customerId, accountNum,
				amount, currency, transactionType);
		return transactionRequest;
	}
}
