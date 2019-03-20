package com.nhom1.customer.controllerimpl;

import java.util.List;

import com.nhom1.customer.controller.IMainFrameController;
import com.nhom1.customer.model.Customer;
import com.nhom1.customer.model.MainFrameQuery;

public class MainFameControllerImpl implements IMainFrameController {
	private MainFrameQuery mainFrameQuery;

	public MainFameControllerImpl() {
		this.mainFrameQuery = new MainFrameQuery();

	}

	public List<Customer> getAllCustomers() {

		return mainFrameQuery.getCustomers();
	}

}
