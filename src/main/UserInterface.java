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
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JLabel headerLabel;
	JProgressBar budgetSpent;
	JLabel progressLabel;
	JLabel liveLabel;
	JLabel pipelineLabel;
	JLabel expiredLabel;
	Color white = Color.decode("#ffffff");
	Color red = Color.decode("#aa0000");
	Color lightBlue = Color.decode("#8dd9f1");


	public static void main(String[] args) {
		new UserInterface();
	}
	
	public UserInterface() {
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Contract Award Manager");
		
		panel = new JPanel();
		this.add(panel);		
		panel.setBackground(Color.white);
		
				
		headerLabel();
		heroImage();
		progressBar();
		progressLabel();

		panel2 = new JPanel();
		panel.add(panel2);		
		panel2.setBackground(lightBlue);
		liveContracts();

		panel3 = new JPanel();
		panel.add(panel3);		
		panel3.setBackground(lightBlue);
		pipelineContracts();

		panel4 = new JPanel();
		panel.add(panel4);		
		panel4.setBackground(red);
		expiredContracts();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void headerLabel() {
		headerLabel = new JLabel("Contract Award Dashboard");
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		headerLabel.setForeground(lightBlue);
		panel.add(headerLabel);
	}
	
	public void heroImage() {
		BufferedImage heroImage; 
		JLabel picture1 = new JLabel();
		try {
		heroImage = ImageIO.read(new File("/Users/user/eclipse-workspace/heroImageMobile.jpg"));
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
		progressLabel = new JLabel("of budget spent");
		progressLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		Color progressBlue = Color.decode("#1353ef");
		progressLabel.setForeground(progressBlue);
		panel.add(progressLabel);
	}

	public void liveContracts() {
		liveLabel = new JLabel("3 live contracts");
		liveLabel.setFont(new Font("Arial", Font.BOLD, 16));
		liveLabel.setForeground(white);
		panel2.add(liveLabel);
	}
	
	public void pipelineContracts() {
		pipelineLabel = new JLabel("2 pipeline contracts");
		pipelineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		pipelineLabel.setForeground(white);
		panel3.add(pipelineLabel);
	}

	public void expiredContracts() {
		expiredLabel = new JLabel("2 expired contracts");
		expiredLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		expiredLabel.setForeground(white);
		panel4.add(expiredLabel);
	}

	
}
