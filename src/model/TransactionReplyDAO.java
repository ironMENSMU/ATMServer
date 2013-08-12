package model;

public class TransactionReplyDAO {

	public TransactionReplyDAO(){}
	
	public TransactionReply createTransactionReply(String transactionId, double balanceBeforeTransaction, double balanceAfterTransaction){
		
		TransactionReply transactionReply = new TransactionReply(transactionId, balanceBeforeTransaction, balanceAfterTransaction);
		return transactionReply;
	}
}
