package model;

import java.util.Date;

public class Account {

	private String accountId;
	private String primaryCustomerID;
	private String jointCustomerID;
	private String productType;
	private String currency;
	private String statementPreference;
	private double interestRate;
	private double balance;
	private Date dateOpened;

	public Account(String accountId, String primaryCustomerID, String jointCustomerID,
			String productType, String currency, String statementPreference,
			double interestRate, double balance, Date dateOpened) {
		this.accountId = accountId;
		this.primaryCustomerID = primaryCustomerID;
		this.jointCustomerID = jointCustomerID;
		this.productType = productType;
		this.currency = currency;
		this.statementPreference = statementPreference;
		this.interestRate = interestRate;
		this.balance = balance;
		this.dateOpened = dateOpened;
	}

	public String getAccountId(){
		
		return accountId;
	}
	
	public String getPrimaryCustomerID() {

		return primaryCustomerID;
	}

	public String getJointCustomerID() {

		return jointCustomerID;
	}

	public String getProductType() {

		return productType;
	}

	public String getCurrency() {

		return currency;
	}

	public String getStatementPreference() {

		return statementPreference;
	}
	
	public double getInterestRate(){
		
		return interestRate;
	}
	
	public double getBalance(){
		
		return balance;
	}
	
	public Date getDateOpened(){
		
		return dateOpened;
	}
	
	public void setBalance(double amount){
		
		balance = amount;
	}

}
