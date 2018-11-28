package com.qa.constants;

public class AccountConstants {

	enum accountTypes {
		SIX_DIGIT_ACCOUNT, EIGHT_DIGIT_ACCOUNT, TEN_DIGIT_ACCOUNT;
	}

	public static final String CREATE_ACCOUNT = "Account successfully created!";
	public static final String DELETE_ACCOUNT = "Account successfully deleted!";
	public static final String ACCOUNT_NOT_FOUND = "Account not found";
	public static final String ACCOUNT_UPDATED = "Account updated!";
	public static final String GET_PRIZE_PATH = "/prize/get/";
	public static final String GET_ACCOUNT_NUMBER_PATH = "/accountnumber/create/";
	public static final String IP = "http://localhost:";
	public static final String BASE_PORT = "8081";
	public static final String NUM_GEN_PORT = "8082";
	public static final String PRIZE_GEN_PORT = "8083";

}
