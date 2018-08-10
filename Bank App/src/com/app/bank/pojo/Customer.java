package com.app.bank.pojo;

import java.time.LocalDate;

public class Customer {

	private final int customerId;
	private String customerName;
	private long contactNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	
    private static int custId;
	
	static {
		custId = 1000;
	}
	
	{
		this.customerId = ++custId;
	}

	public Customer(String customerName, long contactNumber, String emailId, LocalDate dateOfBirth) {
	
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	
}
