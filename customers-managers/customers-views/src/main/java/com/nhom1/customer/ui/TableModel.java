package com.nhom1.customer.ui;

import java.util.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.nhom1.constant.utils.NumberConstant;
import com.nhom1.customer.model.Customer;

public class TableModel extends AbstractTableModel {

	private List<Customer> customersList;
	private String[] colNames = {"MaXe", "Anh1", "Anh2", "Gio", "Ngay"};
	
	
	
	public TableModel() {
		customersList = new ArrayList<Customer>();
	}
	
	
	@Override
	public String getColumnName(int column) {
		
		return this.colNames[column];
	}
	
	
	public int getColumnCount() {
		
		return NumberConstant.NUM_OF_COLUMNS;
	}

	public int getRowCount() {
		
		return this.customersList.size();
	}

	public Object getValueAt(int rowIndex, int colIndex) {
		
		Customer customer = this.customersList.get(rowIndex);
		
		switch (colIndex ) {
		
		case 0:
			return customer.getMaXe();
		case 1:
			return customer.getsAnh1();
		case 2: 
			return customer.getsAnh2();
		case 3: 
			return customer.getsGio();
		case 4:
			return customer.getsNgay();
			
		default:
			return null;
		}			
	}
	public void setCustomerList(List<Customer> customersList) {
		this.customersList = customersList;
		
	}
	
	public void updateTable() {
		fireTableDataChanged();
	}

}
