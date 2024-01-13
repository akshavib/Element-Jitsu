// Author: Akshavi Baskaran 		Purpose: SUMMATIVE ELEMENT JITSU			Date: 12-28-2022
// Card.java

import java.awt.Color; 

// Card class
public class Card {
	public int value; // initializing the value of a card
	public String element; // initialize element of a card
	public Color color; // initialize color of a card 
	
	// Card Constructor 
	public Card(String e, int v, Color c){
		value = v; // set value as variable v
		element = e; // set element as e 
		color = c; // set color as c
	} // end Card Constructor 

	// getValue method to attain value of card 
	public void getValue(int v) {
		value = v;
	} // end getValue 
	
	// getElement method to attain element of card 
	public void getElement(String e) {
		element = e;
	} // end getElement
	
	// getColor method to attain color of a card
	public void getColor(Color c) {
		color = c;
	} // end getColor
	
	// toString method to create a string stating element, value, color
	public String toString() {
		return "Card: " + element + value + color; // return string 
	} // end toString method 
} // end Card class 