package com.nhom1.customer.model;

import java.util.List;

public class MainFrameQuery {
	private Database database = DatabaseHandler.INSTANCE.getInstance();

	public List<Customer> getCustomers() {
		return this.database.getCustomers();
	}

}
