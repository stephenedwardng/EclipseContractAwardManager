package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import behaviours.Cat;
import behaviours.Status;

public class UserInterface extends JFrame {
	
	Buyer buyer;
	Report report;

	JPanel panel;
	JPanel panelHero;
	JPanel panelSpacer;
	JPanel panelBody;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panelSpacer2;
	JPanel panel5;
//	PieChart pieChart;
	JPanel panelCategories;
	JLabel headerLabel;
	JProgressBar budgetSpent;
	JLabel progressLabel;
	JLabel liveLabel;
	JLabel pipelineLabel;
	JLabel expiredLabel;
	JLabel catITLabel;
	Color white = Color.decode("#ffffff");
	Color red = Color.decode("#aa0000");
	Color lightBlue = Color.decode("#8dd9f1");
	Color progressBlue = Color.decode("#1353ef");
	Color green = Color.decode("#00aa00");
	Color orange = Color.decode("#ffaa00");

	public static void main(String[] args) {
		new UserInterface();
	}
	
	public UserInterface() {
		
        buyer = new Buyer("CodeClan", "SC009857568", 250000, "2018-04-05");
        report = new Report(buyer);

        Contract.deleteAll();
        Contract contract1 = new Contract("200 MacBook Pros", "Edward Ng", 1, Status.LIVE, Cat.IT, 1, "2017-07-07", "2018-07-07", 40000, 45000, "Procurement of new laptops for new location in Aberdeen");
        contract1.save();
        Contract contract2 = new Contract("1000 CodeClan pens", "Edward Ng", 2, Status.PIPELINE, Cat.MARKETING, 4, "2017-10-10", "2018-10-10", 3000, 3000, "Procurement of promotional pens for events and students");
        contract2.save();
        Contract contract3 = new Contract("2 Soap Dispensers", "Edward Ng", 3, Status.EXPIRED, Cat.FACILITIES, 2, "2016-05-07", "2017-05-07", 1000, 1500, "Wall mounted soap dispensers");
        contract3.save();
        Contract contract4 = new Contract("6 Phones", "Edward Ng", 4, Status.LIVE, Cat.TELECOM, 3, "2017-03-10", "2018-03-10", 25000, 35000, "Phones for central stall and instructors");
        contract4.save();
        Contract contract5 = new Contract("Business Insurance", "Edward Ng", 5, Status.LIVE, Cat.INSURANCE, 5, "2017-08-09", "2018-08-09", 70000, 80000, "Insurance cover for business");
        contract5.save();
        Contract contract6 = new Contract("Fruit", "Edward Ng", 4, Status.PIPELINE, Cat.FACILITIES, 4, "2017-08-09", "2018-08-09", 2000, 1600, "Fruit to keep students healthy");
        contract6.save();
        Contract contract7 = new Contract("Projectors", "Edward Ng", 3, Status.EXPIRED, Cat.FACILITIES, 2, "2017-08-09", "2018-08-09", 5000, 4600, "Fruit to keep students healthy");
        contract7.save();
		
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Contract Award Manager");
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 0, 50, 0));
		this.add(panel);		
		panel.setBackground(Color.white);

		headerLabel();

		panelHero = new JPanel();
		panelHero.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel.add(panelHero);		
		panelHero.setBackground(white);
						
		panelSpacer = new JPanel();
		panelSpacer.setBorder(new EmptyBorder(20, 0, 10, 0));
		panel.add(panelSpacer);		
		panelSpacer.setBackground(white);
		
		heroImage();
		progressBar();
		progressLabel();

		
		
		panel2 = new JPanel();
		panel.add(panel2);		
		panel2.setBackground(green);
		liveContracts();

		panel3 = new JPanel();
		panel.add(panel3);		
		panel3.setBackground(orange);
		pipelineContracts();

		panel4 = new JPanel();
		panel.add(panel4);		
		panel4.setBackground(red);
		expiredContracts();

		panelSpacer2 = new JPanel();
		panelSpacer2.setBorder(new EmptyBorder(5, 300, 5, 0));
		panel.add(panelSpacer2);		
		panelSpacer2.setBackground(white);

		panel5 = new JPanel();
		panel.add(panel5);		
		panel5.setBackground(white);
		categoriesIT();

//		panelCategories = new JPanel();
//		panel.add(panelCategories);		
//		panelCategories.setBackground(white);
		

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
		panelHero.add(picture1);
	}

	public void progressBar() {
		budgetSpent = new JProgressBar(0, 100);
		budgetSpent.setStringPainted(true);
		budgetSpent.setMinimumSize(getSize());
		budgetSpent.setSize(600, 100);
		budgetSpent.setValue(report.percentageBudgetSpent());
		budgetSpent.setBackground(Color.white);
		budgetSpent.setForeground(Color.red);
		panel.add(budgetSpent);
	}
	
	public void progressLabel() {
		progressLabel = new JLabel("of budget spent");
		progressLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		progressLabel.setForeground(progressBlue);
		panel.add(progressLabel);
	}

	public void liveContracts() {
		Integer numLive = Contract.countContractsByStatus(Status.LIVE);
		String numLiveContracts = numLive.toString();
		liveLabel = new JLabel(numLiveContracts + " live contracts");
		liveLabel.setFont(new Font("Arial", Font.BOLD, 16));
		liveLabel.setForeground(white);
		panel2.add(liveLabel);
	}
	
	public void pipelineContracts() {
		Integer numPipeline = Contract.countContractsByStatus(Status.PIPELINE);
		String numPipelineContracts = numPipeline.toString();
		pipelineLabel = new JLabel(numPipelineContracts + " pipeline contracts");
		pipelineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		pipelineLabel.setForeground(white);
		panel3.add(pipelineLabel);
	}

	public void expiredContracts() {
		Integer numExpired = Contract.countContractsByStatus(Status.EXPIRED);
		String numExpiredContracts = numExpired.toString();
		expiredLabel = new JLabel(numExpiredContracts + " expired contracts");
		expiredLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		expiredLabel.setForeground(white);
		panel4.add(expiredLabel);
	}

	public void categoriesIT() {
		Integer numIT = Contract.countContractsByCategory(Cat.IT);
		String numITContracts = numIT.toString();
		catITLabel = new JLabel("Contracts in IT: " + numITContracts);
		catITLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		catITLabel.setForeground(red);
		panel5.add(catITLabel);
		PieChart pieChart = new PieChart(numIT);
		panel5.add(pieChart);

	}
	
	
	
}
