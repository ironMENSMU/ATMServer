package model;

import java.util.Date;

public class DepositAccount extends Account {

	private double earlyWithdrawlPenalty;
	private double dailyWithdrawlLimit;

	public DepositAccount(String accountId, String primaryCustomerID, String jointCustomerID,
			String productType, String currency, String statementPreference,
			double interestRate, double balance, Date dateOpened, double earlyWithdrawlPenalty,
			double dailyWithdrawlLimit) {

		super(accountId, primaryCustomerID, jointCustomerID, productType, currency,
				statementPreference, interestRate, balance, dateOpened);
		this.earlyWithdrawlPenalty = earlyWithdrawlPenalty;
		this.dailyWithdrawlLimit = dailyWithdrawlLimit;
	}

	public double getEarlyWithdrawlPenalty() {
		return earlyWithdrawlPenalty;
	}

	public double getDailyWithdrawlLimit() {
		return dailyWithdrawlLimit;
	}
}
