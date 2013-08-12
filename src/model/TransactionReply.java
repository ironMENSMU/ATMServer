package model;

public class TransactionReply {
	
	private String transactionId;
	private double balanceBeforeTransaction;
	private double balanceAfterTransaction;
	
	public TransactionReply(String transactionId, double balanceBeforeTransaction, double balanceAfterTransaction){
		
		this.transactionId = transactionId;
		this.balanceBeforeTransaction = balanceBeforeTransaction;
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	
	public String getTransactionId(){
		
		return transactionId;
	}
	
	public double getBalanceBeforeTransaction(){
		
		return balanceBeforeTransaction;
	}
	
	public double getBalanceAfterTransaction(){
		
		return balanceAfterTransaction;
	}
}
