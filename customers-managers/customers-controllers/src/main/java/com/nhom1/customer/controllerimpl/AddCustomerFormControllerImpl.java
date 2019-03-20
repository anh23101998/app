package com.nhom1.customer.controllerimpl;

import com.nhom1.customer.controller.IAddCustomerFormController;
import com.nhom1.customer.model.AddCustomerQuery;
import com.nhom1.customer.model.Customer;

public class AddCustomerFormControllerImpl implements IAddCustomerFormController {
	private AddCustomerQuery addCustomerQuery;

	public AddCustomerFormControllerImpl() {
		this.addCustomerQuery = new AddCustomerQuery();
	}

	public void insertCustomer(Customer customer) {
		this.addCustomerQuery.insertCustomer(customer);
	}

}
