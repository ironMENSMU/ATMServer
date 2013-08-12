package model;

public class TransactionRequest {
	
	private String transactionId;
	private String customerId;
	private String accountNum;
	private double amount;
	private String currency;
	private String transactionType; /*
									 * deposit, withdrawal, loan repayment, loan
									 * installment
									 */

	public TransactionRequest(String transactionId, String customerId, String accountNum,
			double amount, String currency, String transactionType) {
		
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.amount = amount;
		this.currency = currency;
		this.transactionType = transactionType;
	}

	public String getTransactionId(){
		
		return transactionId;
	}
	
	public String getCustomerId() {

		return customerId;
	}

	public String getAccountNum() {

		return accountNum;
	}

	public double getAmount() {

		return amount;
	}

	public String getCurrency() {

		return currency;
	}

	public String getTransactionType() {

		return transactionType;
	}

	public void setAmount(double amount) {

		this.amount = amount;
	}

	public void setCurrency(String currency) {

		this.currency = currency;
	}
}
