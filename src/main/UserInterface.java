package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class UserInterface extends JFrame {

	JPanel panel;
	JLabel headerLabel;
	public static void main(String[] args) {
		new UserInterface();
	}
	
	public UserInterface() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Contract Award Manager");
		
		panel = new JPanel();
		this.add(panel);		
		panel.setBackground(Color.white);
		
		headerLabel = new JLabel("Contract Award Dashboard");
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		Color lightBlue = Color.decode("#8dd9f1");
		headerLabel.setForeground(lightBlue);
		panel.add(headerLabel);
		
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
