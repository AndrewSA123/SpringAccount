package com.qa.ATS;

public class Account {

	private Long ID;
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String accountType;
	private String prize;

	public Account() {

	}

	public Account(String fName, String lName, String accountType, String prize) {

		this.firstName = fName;
		this.lastName = lName;
		this.accountType = accountType;
		this.prize=prize;

	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getID() {
		return this.ID;
	}
	
	public void setID(Long id) {
		this.ID = id;
	}

	public String setFirstName(String name) {

		firstName = name;

		return "First Name Changed";
	}

	public String setLastName(String name) {

		lastName = name;

		return "Last Name Changed";
	}

	public String setAccountNumber(String id) {

		accountNumber = id;

		return "Account Number Changed";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}


}
