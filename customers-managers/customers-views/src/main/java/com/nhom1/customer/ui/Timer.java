package com.nhom1.customer.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class Timer extends Thread {
	private boolean isRunning;
	private JLabel timeLabel;
	private SimpleDateFormat timeFormat;
	
	
	public Timer(JLabel timeLabel) {
		initalizeVariable(timeLabel);
	}


	private void initalizeVariable(JLabel timeLabel) {
		this.timeLabel = timeLabel;
		this.timeFormat = new SimpleDateFormat("hh:mm:ss");
		this.isRunning = true;
		
	}
	@Override
	public void run() {
		while(isRunning) {
			Calendar calendar = Calendar.getInstance();
			Date currentTime = calendar.getTime();
			timeLabel.setText(timeFormat.format(currentTime));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
		
	}

}
