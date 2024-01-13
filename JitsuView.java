// Author: Akshavi Baskaran 			Purpose: The View of Jitsu Game 			Date: 01-09-2023
// JitsuView.java

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.*; 
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


// The Jitsu Game VIEW
// This class provides the Interface for the Jitsu game 
public class JitsuView {
	JFrame window; // create a JFrame 
	GridBagConstraints gbc = new GridBagConstraints(); // new GridBagConstraints 
	JButton OK, card1, card2, card3, info; // buttons needed for interface 
	JLabel compInventory, playerInventory, label1, fireLabelC1, fireLabelC2, fireLabelC3, waterLabelC1, 
			waterLabelC2, waterLabelC3, snowLabelC1, snowLabelC2, snowLabelC3, roundCount,
			fireLabelP1, fireLabelP2, fireLabelP3, waterLabelP1, 
			waterLabelP2, waterLabelP3, snowLabelP1, snowLabelP2, snowLabelP3, compDisplayCard,
			compCardLabel, compElement, card1Element, card2Element, card3Element; // labels needed for interface 
	int x = 1; // round count
	Color peach = new Color(255,218,185); // create new color peach 
	
	// JitsuView constructor
	public JitsuView() {
		window = new JFrame("Element Jitsu"); // name of the JFrame
		JPanel panel = (JPanel) window.getContentPane(); // create JPanel within JFrame
		panel.setLayout(new GridBagLayout()); // layout of panel is GridBagLayout
		
		// Message pop up with instructions 
		JOptionPane.showMessageDialog(window, "Welcome to Element Jitsu! \n Your job is to get 3 cards in your inventory: \n 1. Of the SAME element \n 2. Of DIFFERENT colours \n"
				+ "Before the computer! The label above the 'OK' button will guide you. \n "
				+ "Start off by selecting a card. Choose wisely. Snow beats water, water beats fire, and fire beats snow.\n"
				+ "If you both have the same element, your numbers will be compared. \n Good Luck!","Element Jitsu", JOptionPane.INFORMATION_MESSAGE);
		
		// displaying all the widgets with designated positions 
		roundCount = new JLabel("  Round " + x, SwingConstants.CENTER); // round count label
		roundCount.setFont(new Font("Raanana",Font.BOLD,20)); // setting font 
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 280;
		gbc.gridy = 20;
		gbc.insets = new Insets (5,5,5,5);
		gbc.gridheight = 40;
		gbc.gridwidth = 200;
		panel.add(roundCount, gbc); // add round count label 
		
		// instructions button
		info = new JButton ("ⓘ");
		info.setBorder(new LineBorder(Color.BLACK));
		info.setPreferredSize(new Dimension(20,20));
		info.setOpaque(true);
		info.setEnabled(true);
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel.add(info, gbc); // add round count label 
		
		compInventory = new JLabel("Computer Inventory"); // computer inventory label
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 40;
		gbc.gridy = 80;
		gbc.gridheight = 20;
		gbc.gridwidth = 160;
		gbc.insets = new Insets (5,5,5,5);
		panel.add(compInventory,gbc); // add computer inventory label 
		
		playerInventory = new JLabel("Your Inventory"); // player inventory label
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 580;
		gbc.gridy = 80;
		gbc.gridheight = 20;
		gbc.gridwidth = 120;
		panel.add(playerInventory,gbc); // add player inventory label 
		
		label1 = new JLabel("Please Pick a Card"); // label1 that instructs player what to do, who won, etc.
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 300;
		gbc.gridy = 100;
		gbc.gridheight = 20;
		gbc.gridwidth = 120;
		panel.add(label1,gbc); // add label1 label
		
		// labels for computer's inventory 
		fireLabelC1 = new JLabel("🔥", SwingConstants.CENTER); // first fire label
		// get icon and set components of label
		fireLabelC1.setIcon(new ImageIcon(getClass().getResource("fire.png")));
		fireLabelC1.setBorder(new LineBorder(Color.BLACK));
		fireLabelC1.setBackground(peach);
		fireLabelC1.setPreferredSize(new Dimension(40,40));
		fireLabelC1.setOpaque(true);
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 40;
		gbc.gridy = 120;
		gbc.insets = new Insets (0,0,0,0);
		gbc.gridheight = 40;
		gbc.gridwidth = 40;
		panel.add(fireLabelC1, gbc); // add fire label 1 for computer 
		
		waterLabelC1 = new JLabel("🌊", SwingConstants.CENTER);  // first water label
		// get icon and set components of label
		waterLabelC1.setIcon(new ImageIcon(getClass().getResource("water.png")));
		waterLabelC1.setBorder(new LineBorder(Color.BLACK));
		waterLabelC1.setBackground(peach);
		waterLabelC1.setPreferredSize(new Dimension(40,40));
		waterLabelC1.setOpaque(true);
		gbc.gridx = 80; // x position on grid 
		panel.add(waterLabelC1, gbc); // add water label 1 for computer 
		
		snowLabelC1 = new JLabel("⛄", SwingConstants.CENTER); // first snow label 
		// get icon and set components of label
		snowLabelC1.setIcon(new ImageIcon(getClass().getResource("snow.png")));
		snowLabelC1.setBorder(new LineBorder(Color.BLACK));
		snowLabelC1.setBackground(peach);
		snowLabelC1.setPreferredSize(new Dimension(40,40));
		snowLabelC1.setOpaque(true);
		gbc.gridx = 120; // x position on grid 
		panel.add(snowLabelC1, gbc); // add snow label 1 for computer 
		
		fireLabelC2 = new JLabel("🔥", SwingConstants.CENTER); // second fire label 
		// get icon and set components of label 
		fireLabelC2.setIcon(new ImageIcon(getClass().getResource("fire.png")));
		fireLabelC2.setBorder(new LineBorder(Color.BLACK));
		fireLabelC2.setBackground(peach);
		fireLabelC2.setPreferredSize(new Dimension(40,40));
		fireLabelC2.setOpaque(true);
		gbc.gridx = 40; // x position on grid 
		gbc.gridy = 160; // y position on grid 
		panel.add(fireLabelC2, gbc); // add fire label 2 for computer 
		
		waterLabelC2 = new JLabel("🌊", SwingConstants.CENTER); // second water label 
		// get icon and set components of label 
		waterLabelC2.setIcon(new ImageIcon(getClass().getResource("water.png")));
		waterLabelC2.setBorder(new LineBorder(Color.BLACK));
		waterLabelC2.setBackground(peach);
		waterLabelC2.setPreferredSize(new Dimension (40,40));
		waterLabelC2.setOpaque(true);
		gbc.gridx = 80; // x position on grid 
		panel.add(waterLabelC2, gbc); // add water label 2 for computer 
		
		snowLabelC2 = new JLabel("⛄", SwingConstants.CENTER); // second snow label 
		// get icon and set components of label
		snowLabelC2.setIcon(new ImageIcon(getClass().getResource("snow.png")));
		snowLabelC2.setBorder(new LineBorder(Color.BLACK));
		snowLabelC2.setBackground(peach);
		snowLabelC2.setPreferredSize(new Dimension(40,40));
		snowLabelC2.setOpaque(true);
		gbc.gridx = 120; // x position on grid 
		panel.add(snowLabelC2, gbc); // add snow label 2 for computer 
		
		fireLabelC3 = new JLabel("🔥", SwingConstants.CENTER); // third fire label
		// get icon and set components of label 
		fireLabelC3.setIcon(new ImageIcon(getClass().getResource("fire.png")));
		fireLabelC3.setBorder(new LineBorder(Color.BLACK));
		fireLabelC3.setBackground(peach);
		fireLabelC3.setPreferredSize(new Dimension(40,40));
		fireLabelC3.setOpaque(true);
		gbc.gridx = 40; // x position on grid 
		gbc.gridy = 200; // y position on grid
		panel.add(fireLabelC3, gbc); // add fire label 3 for computer 
		
		waterLabelC3 = new JLabel("🌊", SwingConstants.CENTER); // third water label
		// get icon and set components of label
		waterLabelC3.setIcon(new ImageIcon(getClass().getResource("water.png")));
		waterLabelC3.setBorder(new LineBorder(Color.BLACK));
		waterLabelC3.setBackground(peach);
		waterLabelC3.setPreferredSize(new Dimension(40,40));
		waterLabelC3.setOpaque(true);
		gbc.gridx = 80; // x position on grid 
		panel.add(waterLabelC3, gbc); // add water label 3 for computer 
		
		snowLabelC3 = new JLabel("⛄", SwingConstants.CENTER); // third snow label 
		// get icon and set components of label 
		snowLabelC3.setIcon(new ImageIcon(getClass().getResource("snow.png")));
		snowLabelC3.setBorder(new LineBorder(Color.BLACK));
		snowLabelC3.setBackground(peach);
		snowLabelC3.setPreferredSize(new Dimension(40,40));
		snowLabelC3.setOpaque(true);
		gbc.gridx = 120; // x position on grid 
		panel.add(snowLabelC3, gbc); // add snow label 3 for computer 
		
		OK = new JButton("OK"); // OK button on interface 
		// set components of label 
		OK.setBorder(new LineBorder(Color.BLACK));
		OK.setPreferredSize(new Dimension(60,20));
		OK.setOpaque(true);
		OK.setEnabled(false);
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 340;
		gbc.gridy = 140;
		gbc.gridheight = 20;
		gbc.gridwidth = 60;
		gbc.insets = new Insets(0,80,0,0);
		panel.add(OK, gbc); // add OK button to panel 
		
		compCardLabel = new JLabel("Computer's Card", SwingConstants.CENTER); // label saying computer's card 
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 300;
		gbc.gridy = 180;
		gbc.gridheight = 20;
		gbc.gridwidth = 120;
		gbc.insets = new Insets(0,0,0,0);
		panel.add(compCardLabel,gbc); // add compCardLabel to panel 
		
		compElement = new JLabel("", SwingConstants.CENTER); // label for the element of the computer's card 
		// components and grid bag constraints (dimensions, spacing, positions)
		compElement.setPreferredSize(new Dimension (60,40));
		gbc.gridx = 365;
		gbc.gridy = 220;
		gbc.gridheight = 40;
		gbc.gridwidth = 40;
		gbc.insets = new Insets(0,0,0,25);
		panel.add(compElement, gbc); // add computer element label to panel 
		
		compDisplayCard = new JLabel("", SwingConstants.CENTER); // label for the computer's actual card (rectangle)
		// computer's card components 
		compDisplayCard.setBorder(new LineBorder (Color.BLACK));
		compDisplayCard.setBackground(new Color (104,74,59));
		compDisplayCard.setPreferredSize(new Dimension(100,140));
		compDisplayCard.setOpaque(true);
		// grid bag constraints (dimensions, spacing, positions)
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridx = 320;
		gbc.gridy = 220;
		gbc.gridheight = 140;
		gbc.gridwidth = 100;
		panel.add(compDisplayCard,gbc); // add computer's card to the panel 
		
		// labels for computer's inventory 
		fireLabelP1 = new JLabel("🔥", SwingConstants.CENTER); // first fire label 
		// get icon and set components of label 
		fireLabelP1.setIcon(new ImageIcon(getClass().getResource("fire.png")));
		fireLabelP1.setBorder(new LineBorder(Color.BLACK));
		fireLabelP1.setBackground(peach);
		fireLabelP1.setPreferredSize(new Dimension(40,40));
		fireLabelP1.setOpaque(true);
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 580;
		gbc.gridy = 120;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridheight = 40;
		gbc.gridwidth = 40;
		panel.add(fireLabelP1, gbc); // add fire label 1 for player 
		
		waterLabelP1 = new JLabel("🌊", SwingConstants.CENTER); // first water label 
		// get icon and set components of label 
		waterLabelP1.setIcon(new ImageIcon(getClass().getResource("water.png")));
		waterLabelP1.setBorder(new LineBorder(Color.BLACK));
		waterLabelP1.setBackground(peach);
		waterLabelP1.setPreferredSize(new Dimension(40,40));
		waterLabelP1.setOpaque(true);
		gbc.gridx = 620; // x position 
		gbc.gridy = 120; // y position 
		panel.add(waterLabelP1, gbc); // add water label 1 for player 
		
		snowLabelP1 = new JLabel("⛄", SwingConstants.CENTER); // first snow label 
		// get icon and set components of label 
		snowLabelP1.setIcon(new ImageIcon(getClass().getResource("snow.png")));
		snowLabelP1.setBorder(new LineBorder(Color.BLACK));
		snowLabelP1.setBackground(peach);
		snowLabelP1.setPreferredSize(new Dimension(40,40));
		snowLabelP1.setOpaque(true);
		gbc.gridx = 660; // x position 
		gbc.gridy = 120; // y position
		panel.add(snowLabelP1, gbc); // add snow label 1 for player 
		
		fireLabelP2 = new JLabel("🔥", SwingConstants.CENTER); // second fire label 
		// get icon and set components of label 
		fireLabelP2.setIcon(new ImageIcon(getClass().getResource("fire.png")));
		fireLabelP2.setBorder(new LineBorder(Color.BLACK));
		fireLabelP2.setBackground(peach);
		fireLabelP2.setPreferredSize(new Dimension(40,40));
		fireLabelP2.setOpaque(true);
		gbc.gridx = 580; // x position 
		gbc.gridy = 160; // y position 
		panel.add(fireLabelP2, gbc); // add fire label 2 for player 
		
		waterLabelP2 = new JLabel("🌊", SwingConstants.CENTER); // second water label 
		// get icon and set components of label 
		waterLabelP2.setIcon(new ImageIcon(getClass().getResource("water.png")));
		waterLabelP2.setBorder(new LineBorder(Color.BLACK));
		waterLabelP2.setBackground(peach);
		waterLabelP2.setPreferredSize(new Dimension(40,40));
		waterLabelP2.setOpaque(true);
		gbc.gridx = 620; // x position 
		gbc.gridy = 160; // y position 
		panel.add(waterLabelP2, gbc); // add water label 2 for player 
		
		snowLabelP2 = new JLabel("⛄", SwingConstants.CENTER); // second snow label 
		// get icon and set components of label 
		snowLabelP2.setIcon(new ImageIcon(getClass().getResource("snow.png")));
		snowLabelP2.setBorder(new LineBorder(Color.BLACK));
		snowLabelP2.setBackground(peach);
		snowLabelP2.setPreferredSize(new Dimension(40,40));
		snowLabelP2.setOpaque(true);
		gbc.gridx = 660; // x position 
		panel.add(snowLabelP2, gbc); // add snow label 2 for player 
		
		fireLabelP3 = new JLabel("🔥", SwingConstants.CENTER); // third fire label 
		// get icon and set components of label 
		fireLabelP3.setIcon(new ImageIcon(getClass().getResource("fire.png")));
		fireLabelP3.setBorder(new LineBorder(Color.BLACK));
		fireLabelP3.setBackground(peach);
		fireLabelP3.setPreferredSize(new Dimension(40,40));
		fireLabelP3.setOpaque(true);
		gbc.gridx = 580; // x position 
		gbc.gridy = 200; // y position 
		panel.add(fireLabelP3, gbc); // add fire label 3 for player 
		
		waterLabelP3 = new JLabel("🌊", SwingConstants.CENTER); // third water label 
		// get icon and set components of label 
		waterLabelP3.setIcon(new ImageIcon(getClass().getResource("water.png")));
		waterLabelP3.setBorder(new LineBorder(Color.BLACK));
		waterLabelP3.setBackground(peach);
		waterLabelP3.setPreferredSize(new Dimension(40,40));
		waterLabelP3.setOpaque(true);
		gbc.gridx = 620; // x position 
		panel.add(waterLabelP3, gbc); // add water label 3 for player 
		
		snowLabelP3 = new JLabel("⛄", SwingConstants.CENTER); // third snow label 
		// get icon and set components of label 
		snowLabelP3.setIcon(new ImageIcon(getClass().getResource("snow.png")));
		snowLabelP3.setBorder(new LineBorder(Color.BLACK));
		snowLabelP3.setBackground(peach);
		snowLabelP3.setPreferredSize(new Dimension(40,40));
		snowLabelP3.setOpaque(true);
		gbc.gridx = 660; /// x position 
		panel.add(snowLabelP3, gbc); // add snow label 3 for player 
		
		card1Element = new JLabel("hi", SwingConstants.CENTER); // label for card 1's element 
		card1Element.setPreferredSize(new Dimension (40,40)); // setting the dimensions 
	
		card1 = new JButton (""); // new button for player's card 1
		// set components of card 2 
		card1.setLayout(new FlowLayout());
		card1.setBorder(new LineBorder(Color.BLACK));
		card1.setPreferredSize(new Dimension(100,140));
		card1.setOpaque(true);
		card1.setToolTipText( "This is card 1" );
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 160;
		gbc.gridy = 400;
		gbc.gridheight = 140;
		gbc.gridwidth = 100;
		gbc.insets = new Insets (20,20,20,20);
		card1.add(card1Element); // add card1 LABEL to card1 BUTTON
		panel.add(card1, gbc); // add card1 BUTTON to panel 
		
		card2Element = new JLabel("hi", SwingConstants.CENTER); // label for card 2's element 
		card2Element.setPreferredSize(new Dimension (40,40)); // setting the dimensions 
		
		card2 = new JButton (""); // new button for player's card 2
		// set components of card 2 
		card2.setLayout(new FlowLayout());
		card2.setBorder(new LineBorder(Color.BLACK));
		card2.setPreferredSize(new Dimension(100,140));
		card2.setOpaque(true);
		card2.setToolTipText( "This is card 2" );
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 320;
		gbc.gridy = 400;
		gbc.gridheight = 140;
		gbc.gridwidth = 100;
		card2.add(card2Element); // add card2 LABEL to card1 BUTTON
		panel.add(card2, gbc); // setting the dimensions 
		
		card3Element = new JLabel("hi", SwingConstants.CENTER); // label for card 3's element 
		card3Element.setPreferredSize(new Dimension (40,40)); // setting the dimensions 
		
		card3 = new JButton ("");  // new button for player's card 3
		// set components of card 3
		card3.setLayout(new FlowLayout());
		card3.setBorder(new LineBorder(Color.BLACK));
		card3.setPreferredSize(new Dimension(100,140));
		card3.setOpaque(true);
		card3.setToolTipText( "This is card 3" );
		// grid bag constraints (dimensions, spacing, positions)
		gbc.gridx = 480;
		gbc.gridy = 430;
		gbc.gridheight = 140;
		gbc.gridwidth = 100;
		card3.add(card3Element); // add card3 LABEL to card1 BUTTON
		panel.add(card3, gbc);  // setting the dimensions 
		
		panel.setBackground(peach); // set background colour of the panel 
		URL iconURL = getClass().getResource("elementicon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		window.setIconImage( icon.getImage()); // set icon as inputed image
		window.setSize(760,550); // set size of JFrame
		window.setResizable(true); // setting window as not resizable 
		window.setVisible(true); // set window visible
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // exit window on close 
	} // end JitsuView constructor
	
	// addListener method 
	// set action event handler for player's 3 cards, and OK button
	public void addListener (JitsuController controller) {
		card1.addActionListener(controller); // card1 button
		card2.addActionListener(controller); // card2 button
		card3.addActionListener(controller); // card3 button
		OK.addActionListener(controller); // OK button
		info.addActionListener(controller); // info button 
	} // end addListener method 
	
	// setCardColour method 
	// set the colors of each of the player's cards; get three colors  
	public void setCardColour (Color co1, Color co2, Color co3) {
		card1.setBackground(co1); // card1 color 
		card2.setBackground(co2); // card2 color
		card3.setBackground(co3); // card3 color 
	} // end setCardColor method 
	
	// setCardNumber method 
	// set the numbers of each of the player's cards; get three values 
	public void setCardNumber (int n1, int n2, int n3) {
		card1.setText(""+n1); // set text for card1 label 
		card1.setFont(new Font("Raanana", Font.BOLD, 40)); // change font
		card2.setText(""+n2); // set text for card2 label 
		card2.setFont(new Font("Raanana", Font.BOLD, 40)); // change font 
		card3.setText(""+n3); // set text for card2 label 
		card3.setFont(new Font("Raanana", Font.BOLD, 40)); // change font 
	} // end setCardNumber method 
	
	// setCardElement method 
	// set the colours of each of the player's cards; get the three elements 
	public void setCardElement(String elem1, String elem2, String elem3) {
		String elements [] = {elem1, elem2, elem3}; // string array of the elements 
		// for loop to determine element for each card 
		for (int i = 0; i < 3; i++) {
			// if element is fire, image icon is fire png
			if (elements[i] == "fire") {
				elements[i] = "fire.png"; 
			}// end if 
			// else if element is water, image icon is water png 
			else if  (elements[i] == "water") {
				elements[i] = "water.png";
			} // end else if 
			// else if element is snow, image icon is snow png
			else if  (elements[i] == "snow") {
				elements[i] = "snow.png";
			} // end else if 
		} // end for loop 
		card1Element.setIcon(new ImageIcon(getClass().getResource(elements[0]))); // set card 1 icon
		card2Element.setIcon(new ImageIcon(getClass().getResource(elements[1]))); // set card 2 icon
		card3Element.setIcon(new ImageIcon(getClass().getResource(elements[2]))); // set card 3 icon
	} // end setCardElement method 
	
	// setCompCard method 
	// set color, number, and element of computer's card; get the color, number and element 
	public void setCompCard(Color col, int val, String elem) {
		compDisplayCard.setBackground((col)); // set computer card background as color
		compDisplayCard.setText(""+val); // set computer card text as number 
		compDisplayCard.setFont(new Font("Raanana", Font.BOLD, 40)); // change font 
		String el = ""; // string for determining element png
		// if element is fire, upload fire png 
		if (elem == "fire") {
			el = "fire.png";
		} // end if 
		// else if element is water, upload water png 
		else if  (elem == "water") {
			el = "water.png";
		} // end else if 
		// else if element is snow, upload snow png 
		else if  (elem  == "snow") {
			el = "snow.png";
		} // end else if  
		compElement.setIcon(new ImageIcon(getClass().getResource(el))); // get and set icon element
	} // end setCompCard method 
	
	// playerWin method 
	// sets the backgrounds for the player's inventory: gets the colors from model 
	public void playerWin(Color a, Color b, Color c, Color d, Color e, Color f, Color g, Color h, Color i) {
		label1.setText("You won this round."); // set text for label 1 
		OK.setEnabled(true); // enable OK button 
		// set background for each label in the inventory 
		fireLabelP1.setBackground(a);
		fireLabelP2.setBackground(b); 
		fireLabelP3.setBackground(c); 
		waterLabelP1.setBackground(d);
		waterLabelP2.setBackground(e); 
		waterLabelP3.setBackground(f);
		snowLabelP1.setBackground(g); 
		snowLabelP2.setBackground(h); 
		snowLabelP3.setBackground(i);
	} // end playerWin method 
	
	// computerWin method 
	// sets the backgrounds for the computer's inventory: gets the colors from model 
	public void computerWin(Color a, Color b, Color c, Color d, Color e, Color f, Color g, Color h, Color i) {
		label1.setText("Computer won this round."); // sets the text of label 1
		OK.setEnabled(true); // enables OK button 
		// set background for each label in the inventory 
		fireLabelC1.setBackground(a);
		fireLabelC2.setBackground(b); 
		fireLabelC3.setBackground(c); 
		waterLabelC1.setBackground(d);
		waterLabelC2.setBackground(e); 
		waterLabelC3.setBackground(f);
		snowLabelC1.setBackground(g); 
		snowLabelC2.setBackground(h); 
		snowLabelC3.setBackground(i);
	} // end playerWin method 
	
	// tieRound method 
	// sets the label as tied round 
	public void tieRound() {
		label1.setText("Tie round."); // set text for label 1 
		OK.setEnabled(true); // enable OK button 
	} // end tieRound method 
	
	// hideCompCard method 
	// hides the computer's card from the user 
	public void hideCompCard() {
		label1.setText("Please pick a card."); // sets text as please pick a card 
		compDisplayCard.setBackground(new Color (104,74,59)); // sets background of computer's card as brown 
		compDisplayCard.setText(""); // no number on card
		compElement.setIcon(null); // no element on card
		roundCount.setText("Round " + (x++)); // increment round count
		OK.setEnabled(false); // enable OK button
	} // end hideCompCard method 
	
	// finalWin method 
	// method to display who won the entire game; gets winner from model and controller
	public void finalWin(String winner) {
		label1.setText( winner + " won!"); // set label 1 text as whoever won
		x = 1; // resets round count to 1
	} // end finalWin method 
	
	// setAble method 
	// enables or disables the player's cards to be clicked 
	public void setAble(int i) {
		// if integer is 1, then disable all card buttons 
		if (i == 1) {
			card1.setEnabled(false); // card 1 button
			card2.setEnabled(false); // card 2 button
			card3.setEnabled(false); // card 3 button
		} // end if statement 
		
		// else enable card buttons
		else {
			card1.setEnabled(true); // card 1 button 
			card2.setEnabled(true); // card 2 button
			card3.setEnabled(true); // card 3 button
		} // end else statement 
	} // end setAble method 
} // end JitsuView class 