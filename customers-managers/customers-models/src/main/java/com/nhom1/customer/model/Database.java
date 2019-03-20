package com.nhom1.customer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private List<Customer> customers = new ArrayList<Customer>();

	public List<Customer> getCustomers() {
		return customers;

	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);

	}

	public void removeCustomer(Customer customer) {
		this.customers.remove(customer);

	}

	public Connection conn;
	public Statement statement;

	public static Connection DatabaseConnection() {
		final String url = "jdbc:mysql://localhost:3306/baixe";
		final String user = "root";
		final String password = "anh23101998";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void themID(Customer c) {
		String sql = " INSERT INTO `BAIXE`.`new_table` (Maxe, Anh1, Anh2, Gio, Ngay)  VALUES (?,?,?,?,?);";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getMaXe());
			pst.setString(2, c.getsAnh1());
			pst.setString(3, c.getsAnh2());
			pst.setString(4, c.getsGio());
			pst.setString(5, c.getsNgay());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Sua ID co Mathe cho truoc
	 * 
	 * @param st1 : Mathe
	 * @param st2 : Ten
	 * @param st3 : Anh1
	 * @param st4 : Anh2
	 * @param st5 : Thoigian
	 * @param st6 : Ngay
	 */
	public void updatetable123(String st1, String st2, String st3, String st4, String st5) {
		String sql = "update guixe1 set Anh1 = ?, Anh2 = ?, Gio = ?, Ngay = ? where Maxe = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, st2);
			pst.setString(2, st3);
			pst.setString(3, st4);
			pst.setString(4, st5);
			pst.setString(5, st1);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
