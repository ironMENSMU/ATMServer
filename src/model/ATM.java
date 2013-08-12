package model;

public class ATM {

	private String atmId;
	private String location;
	private int numOf10s;
	private int numOf50s;
	
	public ATM(String atmId, String location, int numOf10s, int numOf50s){
		
		this.atmId = atmId;
		this.location = location;
		this.numOf10s = numOf10s;
		this.numOf50s = numOf50s;
	}
	
	public String getAtmId(){
		
		return atmId;
	}
	
	public String getLocation(){
		
		return location;
	}
	
	public int getNumOf10s(){
		
		return numOf10s;
	}
	
	public int getNumOf50s(){
		
		return numOf50s;
	}
	
	public void setNumOf10s(int num){
		
		this.numOf10s = num;
	}
	
	public void setNumOf50s(int num){
		
		this.numOf50s = num;
	}

}
