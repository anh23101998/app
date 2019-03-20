package com.nhom1.customer.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.nhom1.constant.utils.NumberConstant;
import com.nhom1.constant.utils.StringConstant;
import com.nhom1.customer.callbacks.IAddCustomerCallBack;
import com.nhom1.customer.controller.IAddCustomerFormController;
import com.nhom1.customer.controllerimpl.AddCustomerFormControllerImpl;
import com.nhom1.customer.model.Customer;

public class AddCustomerForm extends JDialog implements ActionListener {
	
	// Định nghĩa các nút
	private JButton saveButton;
	private JButton resetButton;
	private JButton closeButton;
	
	// Định nghĩa các lable và textfield
	private JLabel maxeLabel, anh1Label, anh2Label, gioLabel, ngayLabel;
	private JTextField maxeField, anh1Field, anh2Field, gioField, ngayField;
	
	private IAddCustomerFormController addCustomerFormController;
	private IAddCustomerCallBack addCustomerCallBack = null;
	
	// Định nghĩa hàm tạo
	public AddCustomerForm(JFrame parentFrame) {
		super(parentFrame, StringConstant.CUSTOMER_FORM_TITLE, false);
		initalizeVarialbe();
		ConstructLayout();
		setWindow(parentFrame);
		
	}

	private void ConstructLayout() {
		JPanel customerInfoPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstant.CUSTOMER_FORM_SUBTITLE);
		
		customerInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		
		customerInfoPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridy = 0;
		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);
		
		//================= the first row
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		customerInfoPanel.add(maxeLabel, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		customerInfoPanel.add(maxeField,gc);
		
		//=======next row=======
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		customerInfoPanel.add(anh1Label, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		customerInfoPanel.add(anh1Field,gc);
		
		//==========
        gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		customerInfoPanel.add(anh2Label, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		customerInfoPanel.add(anh2Field,gc);
		
		//===============
        gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		customerInfoPanel.add(gioLabel, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		customerInfoPanel.add(gioField,gc);
		
		//=============
        gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		customerInfoPanel.add(ngayLabel, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		customerInfoPanel.add(ngayField,gc);
		
		// Xu ly nut
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(saveButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(closeButton);
		
		//==============Tu dong thay doi do dai cua nut theo nut khac
		Dimension btnsize = closeButton.getPreferredSize();
		saveButton.setPreferredSize(btnsize);
		resetButton.setPreferredSize(btnsize);
		
		// Dua 2 JPanel vao form add
		this.setLayout(new BorderLayout());
		this.add(customerInfoPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		
	}

	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstant.CUSTOMER_FORM_WINDOW_WIDTH,NumberConstant.CUSTOMER_FORM_WINDOW_HEIGHT);
		setLocationRelativeTo(parentFrame );
		
	}

	private void initalizeVarialbe() {
		// Khởi tạo các nút
		this.saveButton = new JButton(StringConstant.CUSTOMER_FORM_SAVE);
		this.closeButton = new JButton(StringConstant.CUSTOMER_FORM_CLOSE);
		this.resetButton = new JButton(StringConstant.CUSTOMER_FORM_RESET);
		
		// Khởi tạo các lable và textfield
		this.maxeLabel = new JLabel(StringConstant.CUSTOMER_FORM_MAXE);
		this.maxeField = new JTextField(NumberConstant.CUSTOMER_FORM_FIELD_MAXE_LENGTH);
		
		this.anh1Label = new JLabel(StringConstant.CUSTOMER_FORM_ANH1);
		this.anh1Field = new JTextField(NumberConstant.CUSTOMER_FORM_FIELD_ANH1_LENGTH);
		
		this.anh2Label = new JLabel(StringConstant.CUSTOMER_FORM_ANH2);
		this.anh2Field = new JTextField(NumberConstant.CUSTOMER_FORM_FIELD_ANH2_LENGTH);
		
		this.gioLabel = new JLabel(StringConstant.CUSTOMER_FORM_GIO);
		this.gioField = new JTextField(NumberConstant.CUSTOMER_FORM_FIELD_GIO_LENGTH);
		
		this.ngayLabel = new JLabel(StringConstant.CUSTOMER_FORM_NGAY);
		this.ngayField = new JTextField(NumberConstant.CUSTOMER_FORM_FIELD_NGAY_LENGTH);
		
		this.addCustomerFormController = new AddCustomerFormControllerImpl();
		
		closeButton.addActionListener(this);
		resetButton.addActionListener(this);
		saveButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.closeButton) {
			this.setVisible(false);
		} else if (e.getSource() == this.resetButton) {
			this.maxeField.setText(null);
			this.anh1Field.setText(null);
			this.anh2Field.setText(null);
			this.gioField.setText(null);
			this.ngayField.setText(null);
			this.maxeField.setFocusCycleRoot(true);
		} else if (e.getSource() == this.saveButton) {
			// Lay du lieu tren form dua vao cac bien
			String strMaxe = this.maxeField.getText();
			String strAnh1 = this.anh1Field.getText();
			String strAnh2 = this.anh2Field.getText();
			String strGio = this.gioField.getText();
			String strNgay = this.ngayField.getText();
			// Dua vao doi tuong
			Customer customer = new Customer(strMaxe, strAnh1, strAnh2, strGio, strNgay);
			this.addCustomerFormController.insertCustomer(customer);
			this.addCustomerCallBack.customerSaved();
			this.setVisible(false);
		}
		
	}
	
	public void setCallBack(IAddCustomerCallBack addCustomerCallBack) {
		this.addCustomerCallBack = addCustomerCallBack;
		
	}

}
