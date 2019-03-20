package com.nhom1.customer.ui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nhom1.constant.utils.StringConstant;

public class StatusPanel extends JPanel {
	private JLabel statusLable;
	
	private JLabel timeLable;
	private Timer timer;
	
	
	public StatusPanel() {
		initalizesVariable();
		ConstructLayout();
		startTimer();
		
		
	}

	private void startTimer() {
		this.timer.start();
		
	}
	
	private void stopTimer() {
		this.timer.setRunning(false);
	}

	private void ConstructLayout() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(statusLable);
		this.add(timeLable);
		
	}

	private void initalizesVariable() {
		this.statusLable = new JLabel();
		this.statusLable.setText(StringConstant.STATUS_PANEL_TEXT);
		
		this.timeLable = new JLabel();
		this.timer = new Timer(timeLable);
		
		
	}

}
