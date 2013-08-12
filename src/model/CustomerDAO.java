package model;

public class CustomerDAO {

	public CustomerDAO() {
	}

	// create customer object with ID, full name, date of birth, customer type,
	// age, gender, marital status, occupation, education level, email, phone
	// number, preferred mode of communication
	public Customer createCustomer(String id, String fullName,
			String dateOfBirth, String customerType, String age, String gender,
			String maritalStatus, String occupation, String eduLevel,
			String email, String phoneNum, String preferredModeOfCommunication) {

		Customer customer = new Customer(id, fullName, dateOfBirth,
				customerType, age, gender, maritalStatus, occupation, eduLevel,
				email, phoneNum, preferredModeOfCommunication);

		return customer;
	}

	// create customer object with ID, age, gender, marital status, Occupation,
	// and education level
	public Customer createCustomer(String id, String age, String gender,
			String maritalStatus, String occupation, String eduLevel) {

		Customer customer = new Customer(id, age, gender, maritalStatus,
				occupation, eduLevel);

		return customer;
	}

	// create customer object with ID, Email, and Phone number
	public Customer createCustomer(String id, String email, String phoneNum) {

		Customer customer = new Customer(id, email, phoneNum);

		return customer;
	}

	// create customer object with ID and Preferred mode of communication
	public Customer createCustomer(String id,
			String preferredModeOfCommunication) {

		Customer customer = new Customer(id, preferredModeOfCommunication);

		return customer;
	}

	// update customer phone number
	public void updatePhoneNumber(Customer customer, String phoneNum) {
		customer.setPhoneNum(phoneNum);
	}

}
