package model;

import java.util.Date;

public class AccountDAO {

	public AccountDAO() {
	}

	// create an Account
	public Account createAccount(String accountId, String primaryCustomerID,
			String jointCustomerID, String productType, String currency,
			String statementPreference, double interestRate, double balance,
			Date dateOpened) {

		Account account = new Account(accountId, primaryCustomerID,
				jointCustomerID, productType, currency, statementPreference,
				interestRate, balance, dateOpened);
		return account;

	}

	// create Loan Account
	public LoanAccount createLoanAccount(String accountId,
			String primaryCustomerId, String jointCustomerId,
			String productType, String currency, String statementPreference,
			double interestRate, double balance, Date dateOpened,
			String loanPeriod, double latePaymentPenalty,
			double earlyRepaymentPenalty, String collateralId) {

		LoanAccount loanAccount = new LoanAccount(accountId, primaryCustomerId,
				jointCustomerId, productType, currency, statementPreference,
				interestRate, balance, dateOpened, loanPeriod,
				latePaymentPenalty, earlyRepaymentPenalty, collateralId);
		return loanAccount;
	}

	// create Deposit Account
	public DepositAccount createDepositAccount(String accountId,
			String primaryCustomerID, String jointCustomerID,
			String productType, String currency, String statementPreference,
			double interestRate, double balance, Date dateOpened,
			double earlyWithdrawlPenalty, double dailyWithdrawlLimit) {

		DepositAccount depositAccount = new DepositAccount(accountId,
				primaryCustomerID, jointCustomerID, productType, currency,
				statementPreference, interestRate, balance, dateOpened,
				earlyWithdrawlPenalty, dailyWithdrawlLimit);
		return depositAccount;
	}

	public boolean isLowerOrEqualThanBalance(Account account, double amt) {

		double balance = account.getBalance();
		if (amt <= balance) {
			return true;
		} else {
			return false;
		}

	}

	public void deductBalance(Account account, double deductAmt) {

		double originalAmt = account.getBalance();
		double newAmt = originalAmt - deductAmt;
		account.setBalance(newAmt);
	}

	public void addBalance(Account account, double addAmt) {

		double originalAmt = account.getBalance();
		double newAmt = originalAmt + addAmt;
		account.setBalance(newAmt);
	}

}
