package model;

import java.util.Date;

public class LoanAccount extends Account {

	private String loanPeriod;
	private double latePaymentPenalty;
	private double earlyRepaymentPenalty;
	private String collateralId;

	public LoanAccount(String accountId, String primaryCustomerId, String jointCustomerId,
			String productType, String currency, String statementPreference,
			double interestRate, double balance, Date dateOpened, String loanPeriod, double latePaymentPenalty,
			double earlyRepaymentPenalty, String collateralId) {

		super(accountId, primaryCustomerId, jointCustomerId, productType, currency,
				statementPreference, interestRate, balance, dateOpened);
		this.loanPeriod = loanPeriod;
		this.latePaymentPenalty = latePaymentPenalty;
		this.earlyRepaymentPenalty = earlyRepaymentPenalty;
		this.collateralId = collateralId;
	}

	public String getLoanPeriod() {
		return loanPeriod;
	}

	public double getLatePaymentPenalty() {
		return latePaymentPenalty;
	}

	public double getEarlyRepaymentPenalty() {
		return earlyRepaymentPenalty;
	}

	public String getCollateralId() {
		return collateralId;
	}
}
