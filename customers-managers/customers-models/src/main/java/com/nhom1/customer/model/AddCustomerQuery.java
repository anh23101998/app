package com.nhom1.customer.model;

public class AddCustomerQuery {
	private Database database = DatabaseHandler.INSTANCE.getInstance();

	public void insertCustomer(Customer customer) {
		this.database.addCustomer(customer);
	}

}
