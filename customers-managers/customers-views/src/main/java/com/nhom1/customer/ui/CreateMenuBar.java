package com.nhom1.customer.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.nhom1.constant.utils.StringConstant;
import com.nhom1.customer.callbacks.IAddCustomerCallBack;

public class CreateMenuBar extends JMenuBar implements ActionListener, IAddCustomerCallBack {
	private JMenu fileMenu = null;
	private JMenuItem openItem = null;
	private JMenuItem exitItem = null;
	 
	//=============
	private JMenu customer = null;
	private JMenuItem addItem = null;
	private JMenuItem removeItem = null;
	private JMenuItem checkItem = null;
	
	//=============
	private JMenu view = null;
	private JMenu help = null;
	
	// Khai bao them doi tuong AddForm
	private AddCustomerForm addCustomerForm = null;
	private MainFrame mainFrame = null;
	
	public CreateMenuBar(MainFrame parentFrame) {
		fileMenu = new JMenu(StringConstant.MAIN_MENU_FILE);
		openItem = new JMenuItem(StringConstant.MAIN_MENU_OPEN);
		exitItem = new JMenuItem(StringConstant.MAIN_MENU_EXIT);
		
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
	
		//========== Xử lý cho JMenu Customer
		
		customer = new JMenu(StringConstant.MAIN_MENU_CUSTOMER);
		addItem = new JMenuItem(StringConstant.MAIN_MENU_ADD_CUSTOMER);
		removeItem = new JMenuItem(StringConstant.MAIN_MENU_REMOVE_CUSTOMER);
		checkItem = new JMenuItem(StringConstant.MAIN_MENU_CHECK_CUSTOMER);
		customer.add(addItem);
		customer.add(checkItem);
		customer.add(removeItem);
	
		//=========
		
		view = new JMenu(StringConstant.MAIN_MENU_VIEW);
		help = new JMenu(StringConstant.MAIN_MENU_HELP);
		
		
		this.add(fileMenu);
		this.add(customer);
		this.add(view);
		this.add(help);
		
		//========== Xử lý action event
		
		exitItem.addActionListener(this);
		openItem.addActionListener(this);
		addItem.addActionListener(this);
		checkItem.addActionListener(this);

		
		// Khoi tao doi tuong addform
		addCustomerForm = new AddCustomerForm(parentFrame);
		this.mainFrame = parentFrame;// truyen tham chieu den doi tuong MainFrame de su dung ham refreshTable
		setCallBack();
	
	}	
	
	
	private void setCallBack() {
		this.addCustomerForm.setCallBack(this);
		
	}


	// thực hiện hành đông
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem) {
			int action = JOptionPane.showConfirmDialog(getParent(), StringConstant.MAIN_MENU_EXIT_TEXT, StringConstant.MAIN_MENU_EXIT_TITLE, JOptionPane.OK_CANCEL_OPTION);
			if(action == JOptionPane.OK_OPTION) {
				System.gc();
				System.exit(0);
			} 
		} else if (e.getSource() == addItem) {
			addCustomerForm.setVisible(true);
			
		}
	}


	public void customerSaved() {
		this.mainFrame.refreshTable();
		
		
	}

}
