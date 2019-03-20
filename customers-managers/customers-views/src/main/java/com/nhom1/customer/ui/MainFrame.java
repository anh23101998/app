package com.nhom1.customer.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;

import com.nhom1.constant.utils.NumberConstant;
import com.nhom1.constant.utils.StringConstant;
import com.nhom1.customer.controller.IMainFrameController;
import com.nhom1.customer.controllerimpl.MainFameControllerImpl;
import com.nhom1.customer.model.Customer;

public class MainFrame extends JFrame {
	private IMainFrameController mainFrameController;
	private TablePanel tablePanel;
	private StatusPanel statusPanel;
	

	public MainFrame() {
		super(StringConstant.APP_NAME);
		constructAppWindow();
		setJMenuBar(new CreateMenuBar(this));
		
		initalizeVariable();
		constructLayout();	
		refreshTable();
		
		
	}

	public void refreshTable() {
			List<Customer> customers = this.mainFrameController.getAllCustomers();
			this.tablePanel.setTableModel(customers);
			this.tablePanel.updateTable();
	}

	private void constructLayout() {
		this.setLayout(new BorderLayout());
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(statusPanel, BorderLayout.SOUTH);	
		
	}

	private void initalizeVariable() {
		this.mainFrameController = new MainFameControllerImpl();
		this.tablePanel = new TablePanel();
		this.statusPanel = new StatusPanel();
		
	}

	private void constructAppWindow() {
		this.setSize(NumberConstant.APP_WINDOW_SIZE_WIDTH, NumberConstant.APP_WINDOW_SIZE_HIGH); // size giao diện
		this.setLocationRelativeTo(null); // đưa giao diện vào giữa màn hình
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
