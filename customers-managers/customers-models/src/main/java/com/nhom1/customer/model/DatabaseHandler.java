package com.nhom1.customer.model;

public enum DatabaseHandler {
	INSTANCE;
	private Database database = new Database();

	public Database getInstance() {
		return database;
	}

}
