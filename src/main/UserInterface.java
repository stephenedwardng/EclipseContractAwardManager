package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UserInterface extends JFrame {

	JPanel panel;
	JLabel headerLabel;
	JProgressBar budgetSpent;
	public static void main(String[] args) {
		new UserInterface();
	}
	
	public UserInterface() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Contract Award Manager");
		
		panel = new JPanel();
		this.add(panel);		
		panel.setBackground(Color.white);
		
		Color white = Color.decode("#ffffff");
		Color red = Color.decode("#aa0000");
				
		headerLabel();
		heroImage();
		progressBar();
		progressLabel();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void headerLabel() {
		headerLabel = new JLabel("Contract Award Dashboard");
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		Color lightBlue = Color.decode("#8dd9f1");
		headerLabel.setForeground(lightBlue);
		panel.add(headerLabel);
	}
	
	public void heroImage() {
		BufferedImage heroImage; 
		JLabel picture1 = new JLabel();
		try {
		heroImage = ImageIO.read(new File("/Users/user/eclipse-workspace/heroImageTagline.jpg"));
		picture1 = new JLabel(new ImageIcon(heroImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		panel.add(picture1);
	}

	public void progressBar() {
		budgetSpent = new JProgressBar(0, 100);
		budgetSpent.setStringPainted(true);
		budgetSpent.setMinimumSize(getSize());
		budgetSpent.setSize(600, 100);
		budgetSpent.setValue(70);
		budgetSpent.setBackground(Color.white);
		budgetSpent.setForeground(Color.red);
		panel.add(budgetSpent);
	}
	
	public void progressLabel() {
		headerLabel = new JLabel("of budget spent");
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		Color progressBlue = Color.decode("#1353ef");
		headerLabel.setForeground(progressBlue);
		panel.add(headerLabel);
	}

	
}
