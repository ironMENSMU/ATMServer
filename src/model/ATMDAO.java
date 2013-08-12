package model;

public class ATMDAO {

	public ATMDAO(){}
	
	public ATM createATM(String atmId, String location, int numOf10s, int numOf50s){
		
		ATM atm = new ATM(atmId, location, numOf10s, numOf50s);
		return atm;
	}
	
	public void updateBalance(ATM atm, int numOf10s, int numOf50s){
		
		atm.setNumOf10s(numOf10s);
		atm.setNumOf50s(numOf50s);
	}
	

}
