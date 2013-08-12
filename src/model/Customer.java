package model;

public class Customer {

	private String id;
	private String fullName;
	private String customerType;
	private String dateOfBirth;
	private String age;
	private String gender;
	private String maritalStatus;
	private String occupation;
	private String eduLevel;
	private String email;
	private String phoneNum;
	private String preferredModeOfCommunication;

	public Customer(String id, String fullName, String dateOfBirth,
			String customerType, String age, String gender, String maritalStatus,
			String occupation, String eduLevel, String email, String phoneNum,
			String preferredModeOfCommunication) {
		this.id = id;
		this.fullName = fullName;
		this.customerType = customerType;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.eduLevel = eduLevel;
		this.email = email;
		this.phoneNum = phoneNum;
		this.preferredModeOfCommunication = preferredModeOfCommunication;

	}

	public Customer(String id, String age, String gender,
			String maritalStatus, String occupation, String eduLevel) {
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.eduLevel = eduLevel;
	}
	
	public Customer(String id, String email, String phoneNum){
		this.id = id;
		this.email = email;
		this.phoneNum = phoneNum;
	}
	
	public Customer(String id, String preferredModeOfCommunication){
		this.id = id;
		this.preferredModeOfCommunication = preferredModeOfCommunication;
	}
	
	public String getId(){
		return id;
	}
	
	public String getFullName(){
		return fullName;
	}
	
	public String getCustomerType(){
		return customerType;
	}
	
	public String getdateOfBirth(){
		return dateOfBirth;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getMaritalStatus(){
		return maritalStatus;
	}
	
	public String getOccupation(){
		return occupation;
	}
	
	public String getEduLevel(){
		return eduLevel;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhoneNum(){
		return phoneNum;
	}
	
	public String getPreferredModeOfCommunication(){
		return preferredModeOfCommunication;
	}
	
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}

}
