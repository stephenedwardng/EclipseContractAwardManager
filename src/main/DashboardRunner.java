package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardRunner {

	public static void main(String[] args) {
		
		displayDashboard();

	}
	
	public static void displayDashboard()
	{
		JFrame myFrame = new JFrame(); 
		
		JPanel myPanel = new JPanel();
		
		JLabel mainMenuLabel = new JLabel("Main Menu");
		
		JButton goToMenu2 = new JButton("Go to Menu 2");
		JButton goToMenu3 = new JButton("Go to Menu 3");
		
		myPanel.add(mainMenuLabel);
		myPanel.add(goToMenu2);
		myPanel.add(goToMenu3);
		myFrame.add(myPanel);
		
		myFrame.setSize(1000,1000);
		
		myFrame.setLocationRelativeTo(null); 
		
		myFrame.setVisible(true);
		

	}




}